package com.aysu.service;


import com.aysu.dto.request.DoRegisterRequestDto;
import com.aysu.exception.AuthServiceException;
import com.aysu.exception.ErrorType;
import com.aysu.manager.IUserProfileManager;
import com.aysu.mapper.IAuthMapper;
import com.aysu.rabbitmq.model.SaveAuthModel;
import com.aysu.rabbitmq.producer.CreateUserProducer;
import com.aysu.repository.IAuthRepository;
import com.aysu.repository.entity.Auth;
import com.aysu.utility.JwtTokenManager;
import com.aysu.utility.ServiceManager;
import com.aysu.dto.request.DoLoginRequestDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthService extends ServiceManager<Auth, Long> {

    private final IAuthRepository repository;
    private final JwtTokenManager jwtTokenManager;
    private final IUserProfileManager userProfileManager;
    private final CreateUserProducer createUserProducer;


    public AuthService(IAuthRepository repository, JwtTokenManager jwtTokenManager, IUserProfileManager userProfileManager, CreateUserProducer createUserProducer) {
        super(repository);
        this.repository = repository;
        this.jwtTokenManager = jwtTokenManager;
        this.userProfileManager = userProfileManager;
        this.createUserProducer = createUserProducer;
    }

    public String doLogin(DoLoginRequestDto dto) {

        Optional<Auth> auth = repository.findOptionalByUsernameAndPassword(dto.getUsername(), dto.getPassword());
        if (auth.isEmpty())
            throw new AuthServiceException(ErrorType.LOGIN_USERNAME_OR_PASSWORD_NOT_EXISTS);

        // return    auth.get().getId().toString();
        return jwtTokenManager.createToken(auth.get().getId()).get();
    }

    public Auth doRegister(DoRegisterRequestDto dto) {

        Auth auth = IAuthMapper.INSTANCE.toAuth(dto);
        auth.setCreateAt(System.currentTimeMillis());
        auth.setState(true);
        save(auth);
        /*
        userProfileManager.save(UserProfileSaveRequestDto.builder()
                .authid(auth.getId())
                .username(auth.getUsername())
                .email(auth.getEmail())
                .build());
         */
      //  userProfileManager.save(IAuthMapper.INSTANCE.fromAuth(auth));

        //Mesajı RabbitMQ'ya gönderdik
        createUserProducer.convertAndSend(SaveAuthModel.builder()
                .authid(auth.getId())
                .username(auth.getUsername())
                .email(auth.getEmail())
                .build());
        return auth;
    }

    // Tokensiz
/*
    public List<Auth> findAll() {
        return repository.findAll();
    }
    */


    public List<Auth> findAll(String token) {

        Optional<Long> id = null;

        try {
            id = jwtTokenManager.getIdFromToken(token);
            System.out.println("ID: " + id);
        } catch (Exception e) {
            throw new AuthServiceException(ErrorType.INVALID_TOKEN);
        }
        if (findById(id.get()).isEmpty()) {
            throw new AuthServiceException(ErrorType.INVALID_TOKEN); // FIXME
        }
        return repository.findAll();
    }
}
