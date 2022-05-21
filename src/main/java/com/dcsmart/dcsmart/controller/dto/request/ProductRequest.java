package com.dcsmart.dcsmart.controller.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {

    private String product_name;

    private String product_description;

    private String barcode;

    private Integer quantity;

    private Double price;

    private Double discount;

}
