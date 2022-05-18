package com.dcsmart.dcsmart.controller;


import com.dcsmart.dcsmart.controller.dto.ProfileRequest;
import com.dcsmart.dcsmart.controller.dto.ProfileResponse;
import com.dcsmart.dcsmart.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @PostMapping("/save")
    public void save(@RequestBody ProfileRequest profile){
        this.profileService.save(profile);
    }

    @GetMapping("/")
    public List<ProfileResponse> findAll(){
        return this.profileService.findAll();
    }


}
