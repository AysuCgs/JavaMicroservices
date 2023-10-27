package com.aysu.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserProfileSaveRequestDto {

    private  Long id;
    private Long authid;
    private String username;
    private String email;
    private String ad;
    private String address;
    private String phone;
    private String avatar;
    private  Long createAt;
    private boolean state;

}
