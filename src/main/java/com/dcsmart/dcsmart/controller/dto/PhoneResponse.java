package com.dcsmart.dcsmart.controller.dto;

import com.dcsmart.dcsmart.model.Phone;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhoneResponse {

    private Long id;

    private String number;

    public static PhoneResponse converter(Phone phone){

        PhoneResponse currentPhone = new PhoneResponse();
        currentPhone.setId(phone.getId());
        currentPhone.setNumber(phone.getNumber());

        return currentPhone;
    }


}
