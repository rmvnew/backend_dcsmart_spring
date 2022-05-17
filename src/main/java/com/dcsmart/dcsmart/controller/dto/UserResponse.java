package com.dcsmart.dcsmart.controller.dto;

import com.dcsmart.dcsmart.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {

    private Long userId;

    private String password;

    private PersonResponse person;

    public static UserResponse converter(User user){

        var currentUser = new UserResponse();
        currentUser.setUserId(user.getUserId());
        currentUser.setPassword(user.getPassword());
        currentUser.setPerson(PersonResponse.converter(user.getPerson()));
        return currentUser;
    }

}
