package com.dcsmart.dcsmart.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorsMsg {


    USER_NF("101","Usuário não encontrado"),
    USER_E("102","Usuário já cadastrador"),
    PHONE_NF("201","Telefone não encontrado"),
    PHONE_E("202","Telefone já cadastrador");

    private String code;
    private String message;


}
