package com.dcsmart.dcsmart.controller.dto.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {

    private Long profile_id;

    private String name;

    private String register;

    private String email;

    private String password;

    private String phone_number;

    private String zip_code;

    private String city;

    private String street;

    private String district;

    private String address_number;

    private String state;

    private String country;

}
