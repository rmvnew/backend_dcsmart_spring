package com.dcsmart.dcsmart.controller.dto.response;

import com.dcsmart.dcsmart.model.Category;
import com.dcsmart.dcsmart.model.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponse {

    private Long productId;

    private String product_name;

    private String product_description;

    private String barcode;

    private Integer quantity;

    private Double price;

    private Double discount;


    public static ProductResponse converter(Product product){
        var currentProduct = new ProductResponse();
        currentProduct.setProductId(product.getProductId());
        currentProduct.setProduct_name(product.getProduct_name());
        currentProduct.setProduct_description(product.getProduct_description());
        currentProduct.setBarcode(product.getBarcode());
        currentProduct.setPrice(product.getPrice());
        currentProduct.setQuantity(product.getQuantity());
        currentProduct.setDiscount(product.getDiscount());


        return currentProduct;
    }

}
