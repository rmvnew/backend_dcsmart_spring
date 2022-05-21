package com.dcsmart.dcsmart.service.impl;

import com.dcsmart.dcsmart.controller.dto.request.ProductRequest;
import com.dcsmart.dcsmart.controller.dto.response.ProductResponse;
import com.dcsmart.dcsmart.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public void save(ProductRequest productRequest) {

    }

    @Override
    public List<ProductResponse> findAll() {
        return null;
    }

    @Override
    public ProductResponse findById(Long id) {
        return null;
    }

    @Override
    public ProductResponse findByName(String name) {
        return null;
    }

    @Override
    public ProductResponse update(Long id, ProductRequest productRequest) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
