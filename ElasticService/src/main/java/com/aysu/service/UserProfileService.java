package com.aysu.service;

import com.aysu.dto.request.UserProfileSaveRequestDto;
import com.aysu.mapper.IUserProfileMapper;
import com.aysu.repository.IUserProfileRepository;
import com.aysu.repository.entity.UserProfile;
import com.aysu.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService extends ServiceManager<UserProfile, Long> {

    private final IUserProfileRepository iUserProfileRepository;


    public UserProfileService(IUserProfileRepository iUserProfileRepository) {
        super(iUserProfileRepository);
        this.iUserProfileRepository = iUserProfileRepository;
    }
    public void saveDto(UserProfileSaveRequestDto dto){
      //  if(!iUserProfileRepository.existsUserProfileById(dto.getId())) {
            save(IUserProfileMapper.INSTANCE.toUserProfile(dto));
        //    return true;
       // }
        //return false;
    }
}
