package com.aysu.mapper;

import com.aysu.dto.request.DoRegisterRequestDto;
import com.aysu.dto.request.UserProfileSaveRequestDto;
import com.aysu.repository.entity.Auth;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-01T14:22:05+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8.1 (Amazon.com Inc.)"
)
@Component
public class IAuthMapperImpl implements IAuthMapper {

    @Override
    public Auth toAuth(DoRegisterRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Auth.AuthBuilder auth = Auth.builder();

        auth.username( dto.getUsername() );
        auth.email( dto.getEmail() );
        auth.password( dto.getPassword() );

        return auth.build();
    }

    @Override
    public UserProfileSaveRequestDto fromAuth(Auth auth) {
        if ( auth == null ) {
            return null;
        }

        UserProfileSaveRequestDto.UserProfileSaveRequestDtoBuilder userProfileSaveRequestDto = UserProfileSaveRequestDto.builder();

        userProfileSaveRequestDto.authid( auth.getId() );
        userProfileSaveRequestDto.username( auth.getUsername() );
        userProfileSaveRequestDto.email( auth.getEmail() );

        return userProfileSaveRequestDto.build();
    }
}
