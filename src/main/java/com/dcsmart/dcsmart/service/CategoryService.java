package com.dcsmart.dcsmart.service;

import com.dcsmart.dcsmart.controller.dto.request.CategoryRequest;
import com.dcsmart.dcsmart.controller.dto.response.CategoryResponse;

import java.util.List;

public interface CategoryService {

    void save(CategoryRequest categoryRequest);

    List<CategoryResponse> findAll();

    CategoryResponse findById(Long id);

    CategoryResponse findByName(String name);

    CategoryResponse update(Long id, CategoryRequest categoryRequest);

    void delete(Long id);

}
