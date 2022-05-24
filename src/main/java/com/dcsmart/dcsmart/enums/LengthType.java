package com.dcsmart.dcsmart.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LengthType {

    CPF_MIN(11),
    CPF_MAX(14);

    private int value;

}
