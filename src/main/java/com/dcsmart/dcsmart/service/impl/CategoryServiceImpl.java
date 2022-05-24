package com.dcsmart.dcsmart.service.impl;

import com.dcsmart.dcsmart.controller.dto.request.CategoryRequest;
import com.dcsmart.dcsmart.controller.dto.response.CategoryResponse;
import com.dcsmart.dcsmart.exception.CategoryNotFoundException;
import com.dcsmart.dcsmart.model.Category;
import com.dcsmart.dcsmart.repository.CategoryRepository;
import com.dcsmart.dcsmart.service.CategoryService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void save(CategoryRequest categoryRequest) {

        var currentCategory = new Category();
        currentCategory.setCategory_name(categoryRequest.getCategory_name());
        currentCategory.setIsActive(true);
        currentCategory.setCreateAt(LocalDateTime.now(ZoneOffset.UTC));
        currentCategory.setUpdateAt(LocalDateTime.now(ZoneOffset.UTC));
        this.categoryRepository.save(currentCategory);

    }

    @Override
    public List<CategoryResponse> findAll() {
        return this.categoryRepository.findAll()
                .stream().map(CategoryResponse::converter)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryResponse findById(Long id) {
        return CategoryResponse.converter(this.categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(
                        String.format("A categoria com id %d não foi encontrado",id)
                )));
    }

    @Override
    public CategoryResponse findByName(String name) {

        Category category = this.categoryRepository.findByName(name)
                .orElseThrow(() -> new CategoryNotFoundException(
                    String.format("A categoria %s não foi encontrada",name)
                ));
        return CategoryResponse.converter(category);
    }

    @Override
    public CategoryResponse update(Long id, CategoryRequest categoryRequest) {

        Category category = this.categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(
                        String.format("A categoria com id %d não foi encontrado",id)
                ));

        category.setCategory_name(categoryRequest.getCategory_name());
        category.setUpdateAt(LocalDateTime.now(ZoneOffset.UTC));

        this.categoryRepository.save(category);

        return this.findById(id);
    }

    @Override
    public void delete(Long id) {

        Category category = this.categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(
                        String.format("A categoria com id %d não foi encontrado",id)
                ));

        category.setIsActive(false);
        category.setUpdateAt(LocalDateTime.now(ZoneOffset.UTC));

        this.categoryRepository.save(category);

    }
}
