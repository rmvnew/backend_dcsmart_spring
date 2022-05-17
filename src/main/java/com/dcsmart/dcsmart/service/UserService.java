package com.dcsmart.dcsmart.service;

import com.dcsmart.dcsmart.controller.dto.AddressRequest;
import com.dcsmart.dcsmart.controller.dto.UserRequest;
import com.dcsmart.dcsmart.model.Address;
import com.dcsmart.dcsmart.model.User;

import java.util.List;

public interface UserService {

    void save(UserRequest user);

    List<User> findAll();

    User findById(Long id);

    User findByName(String name);

    User update(Long id, UserRequest userRequest);

    void delete(Long id);

}
