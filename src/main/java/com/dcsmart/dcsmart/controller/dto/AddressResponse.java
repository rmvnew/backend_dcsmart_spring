package com.dcsmart.dcsmart.controller.dto;

import com.dcsmart.dcsmart.model.Address;
import com.dcsmart.dcsmart.model.Person;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressResponse {

    private Long address_id;
    private String street;
    private String district;
    private String city;
    private String number;
    private String state;
    private String country;


    public static AddressResponse converter(Address address){
        var currentAddress = new AddressResponse();
        currentAddress.setAddress_id(address.getAddress_id());
        currentAddress.setStreet(address.getStreet());
        currentAddress.setDistrict(address.getDistrict());
        currentAddress.setCity(address.getCity());
        currentAddress.setState(address.getState());
        currentAddress.setCountry(address.getCountry());
        currentAddress.setNumber(address.getAddress_number());

        return currentAddress;
    }
}
