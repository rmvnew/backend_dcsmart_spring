package com.dcsmart.dcsmart.controller.dto.response;

import com.dcsmart.dcsmart.exception.UserNotFoundException;
import com.dcsmart.dcsmart.model.User;
import com.sun.jersey.api.NotFoundException;
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

//        try{

            currentUser.setUserId(user.getUserId());
            currentUser.setPassword(user.getPassword());
            currentUser.setPerson(PersonResponse.converter(user.getPerson()));

//        }catch (NullPointerException ex){
////            System.out.println(ex.getMessage());
//            throw new UserNotFoundException(ex.getMessage());
//        }
        return currentUser;


    }

}
