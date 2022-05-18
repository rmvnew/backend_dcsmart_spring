package com.dcsmart.dcsmart.controller;

import com.dcsmart.dcsmart.controller.dto.UserRequest;
import com.dcsmart.dcsmart.controller.dto.UserResponse;
import com.dcsmart.dcsmart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public void save(@RequestBody UserRequest user){
        this.userService.save(user);
    }
    
    @GetMapping("/")
    public List<UserResponse> findAll(){
        return this.userService.findAll();
    }

}
