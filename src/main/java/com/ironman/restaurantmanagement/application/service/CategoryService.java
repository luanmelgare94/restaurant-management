package com.ironman.restaurantmanagement.application.service;

import com.ironman.restaurantmanagement.application.dto.category.CategoryBodyDto;
import com.ironman.restaurantmanagement.application.dto.category.CategoryDto;
import com.ironman.restaurantmanagement.application.dto.category.CategorySavedDto;
import com.ironman.restaurantmanagement.application.dto.category.CategorySmallDto;
import java.util.List;

public interface CategoryService {

    List<CategorySmallDto> findAll();
    CategoryDto findById(Long id);
    CategorySavedDto create(CategoryBodyDto categoryBodyDto);
    CategorySavedDto update(Long id, CategoryBodyDto categoryBodyDto);
    CategorySavedDto disable(Long id);
    List<CategorySmallDto> findByState(String state);
    List<CategorySmallDto> findByName(String name);

}