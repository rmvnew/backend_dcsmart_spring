package com.dcsmart.dcsmart.controller;

import com.dcsmart.dcsmart.controller.dto.UserRequest;
import com.dcsmart.dcsmart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public void save(@RequestBody UserRequest user){
        this.userService.save(user);
    }

}
