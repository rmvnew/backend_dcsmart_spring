package com.dcsmart.dcsmart.controller;

import com.dcsmart.dcsmart.controller.dto.request.UserRequest;
import com.dcsmart.dcsmart.controller.dto.response.UserResponse;
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
    public void save(@RequestBody UserRequest user) {
        this.userService.save(user);
    }

    @GetMapping("/all")
    public List<UserResponse> findAll() {
        return this.userService.findAll();
    }

    @GetMapping("/{id}")
    public UserResponse findById(@PathVariable Long id) {
        return this.userService.findById(id);
    }

    @GetMapping("/nameFilter")
    public UserResponse findByName(@RequestParam String name){
        return this.userService.findByName(name);
    }

    @PutMapping("/{id}/edit")
    public UserResponse update(@PathVariable Long id, @RequestBody UserRequest user){
        return this.userService.update(id,user);
    }

    @PatchMapping("/{id}")
    public void delete(@PathVariable Long id){
        this.userService.delete(id);
    }

}
