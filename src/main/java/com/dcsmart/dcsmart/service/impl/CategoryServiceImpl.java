package com.dcsmart.dcsmart.service.impl;

import com.dcsmart.dcsmart.controller.dto.request.CategoryRequest;
import com.dcsmart.dcsmart.controller.dto.response.CategoryResponse;
import com.dcsmart.dcsmart.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Override
    public void save(CategoryRequest categoryRequest) {

    }

    @Override
    public List<CategoryResponse> findAll() {
        return null;
    }

    @Override
    public CategoryResponse findById(Long id) {
        return null;
    }

    @Override
    public CategoryResponse findByName(String name) {
        return null;
    }

    @Override
    public CategoryResponse update(Long id, CategoryRequest categoryRequest) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
