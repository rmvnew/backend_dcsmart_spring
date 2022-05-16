package com.dcsmart.dcsmart.controller.dto;

import com.dcsmart.dcsmart.model.Person;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class AddressRequest {

    private String street;

    private String district;

    private String number;

    private String state;

    private String country;

    private Boolean isActive;

    private Person person;
}
