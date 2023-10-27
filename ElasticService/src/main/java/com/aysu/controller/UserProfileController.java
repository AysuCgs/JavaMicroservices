package com.aysu.controller;

import com.aysu.dto.request.UserProfileSaveRequestDto;
import com.aysu.repository.entity.UserProfile;
import com.aysu.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.aysu.constant.EndPoints.*;


//http://localhost:9100/elastic/user
@RequiredArgsConstructor
@RestController
@RequestMapping(ELASTIC+USER)
public class UserProfileController {

    private final UserProfileService userProfileService;

    // https://localhost:9100/elastic/user/save
    @PostMapping(SAVE)
    public ResponseEntity<Boolean> save(@RequestBody UserProfileSaveRequestDto dto){
        userProfileService.saveDto(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping(GETALL)
    public ResponseEntity<Iterable<UserProfile>> findAll(){
        return ResponseEntity.ok(userProfileService.findAll());
    }
    // http://localhost:9100/elastic/user/hi
    @GetMapping("/hi")
    public String info() {
        return "HI: Elastic Service";
    }

}
