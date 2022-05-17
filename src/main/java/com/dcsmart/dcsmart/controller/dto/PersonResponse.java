package com.dcsmart.dcsmart.controller.dto;


import com.dcsmart.dcsmart.model.Address;
import com.dcsmart.dcsmart.model.Person;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class PersonResponse {

    private Long id;

    private String name;

    private String register;

    private String email;

    private Set<PhoneResponse> phones;

    private AddressResponse address;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;

    public static PersonResponse converter(Person person){
        var currentClient = new PersonResponse();
        currentClient.setId(person.getPersonId());
        currentClient.setRegister(person.getRegister());
        currentClient.setName(person.getName());
        currentClient.setEmail(person.getEmail());
        currentClient.setPhones(person.getPhones().stream().map((PhoneResponse::converter)).collect(Collectors.toSet()));
        currentClient.setAddress(AddressResponse.converter(person.getAddress()));
        currentClient.setCreateAt(person.getCreateAt());
        currentClient.setUpdateAt(person.getUpdateAt());
        return currentClient;
    }


}
