package com.dcsmart.dcsmart.service;

import com.dcsmart.dcsmart.controller.dto.request.UserRequest;
import com.dcsmart.dcsmart.controller.dto.response.UserResponse;

import java.util.List;

public interface UserService {

    void save(UserRequest user);

    List<UserResponse> findAll();

    UserResponse findById(Long id);

    UserResponse findByName(String name);

    UserResponse update(Long id, UserRequest userRequest);

    void delete(Long id);

}
