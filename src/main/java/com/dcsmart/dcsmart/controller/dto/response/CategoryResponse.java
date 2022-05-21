package com.dcsmart.dcsmart.controller.dto.response;


import com.dcsmart.dcsmart.model.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryResponse {

    private Long categoryId;

    private String category_name;


    
    public static CategoryResponse converter(Category category){
        var currentCategory = new CategoryResponse();
        currentCategory.setCategoryId(category.getCategoryId());
        currentCategory.setCategory_name(category.getCategory_name());

        return currentCategory;
    }

}
