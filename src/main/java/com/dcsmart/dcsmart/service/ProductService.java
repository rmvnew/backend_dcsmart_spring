package com.dcsmart.dcsmart.service;

import com.dcsmart.dcsmart.controller.dto.request.CategoryRequest;
import com.dcsmart.dcsmart.controller.dto.request.ProductRequest;
import com.dcsmart.dcsmart.controller.dto.response.CategoryResponse;
import com.dcsmart.dcsmart.controller.dto.response.ProductResponse;
import com.dcsmart.dcsmart.model.Category;

import java.util.List;

public interface ProductService {

    void save(ProductRequest productRequest);

    List<ProductResponse> findAll();

    ProductResponse findById(Long id);

    ProductResponse findByName(String name);

    ProductResponse update(Long id, ProductRequest productRequest);

    void delete(Long id);


}
