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
        currentPhone.setId(phone.getPhoneId());
        currentPhone.setNumber(phone.getPhone_number());

        return currentPhone;
    }


}
