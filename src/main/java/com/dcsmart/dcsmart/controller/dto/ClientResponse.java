package com.dcsmart.dcsmart.controller.dto;


import com.dcsmart.dcsmart.model.Client;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class ClientResponse {

    private Long id;

    private String name;

    private String register;

    private String email;

    private Set<PhoneResponse> phones;

    public static ClientResponse converter(Client client){
        var currentClient = new ClientResponse();
        currentClient.setId(client.getId());
        currentClient.setRegister(client.getRegister());
        currentClient.setName(client.getName());
        currentClient.setEmail(client.getEmail());
        currentClient.setPhones(client.getPhones().stream().map((PhoneResponse::converter)).collect(Collectors.toSet()));
        return currentClient;
    }


}
