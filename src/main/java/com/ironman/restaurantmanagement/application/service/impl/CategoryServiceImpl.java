package com.ironman.restaurantmanagement.application.service.impl;

import com.ironman.restaurantmanagement.application.dto.category.CategoryBodyDto;
import com.ironman.restaurantmanagement.application.dto.category.CategoryDto;
import com.ironman.restaurantmanagement.application.dto.category.CategorySavedDto;
import com.ironman.restaurantmanagement.application.dto.category.CategorySmallDto;
import com.ironman.restaurantmanagement.application.mapper.CategoryMapper;
import com.ironman.restaurantmanagement.application.service.CategoryService;
import com.ironman.restaurantmanagement.persistence.entity.Category;
import com.ironman.restaurantmanagement.persistence.repository.CategoryRepository;
import com.ironman.restaurantmanagement.shared.state.enums.State;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

// Lombok annotation
@RequiredArgsConstructor

// Spring Stereotype annotation
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public List<CategorySmallDto> findAll() {
        return ((List<Category>) categoryRepository.findAll())
                .stream()
                .map(categoryMapper::toSmallDto)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto findById(Long id) {
        return categoryRepository.findById(id)
                .map(categoryMapper::toDto)
                .orElse(new CategoryDto());
    }

    @Override
    public CategorySavedDto create(CategoryBodyDto categoryBodyDto) {
        return categoryMapper.toSavedDto(
                categoryRepository.save(
                        fillFieldsForCreate(
                                categoryMapper.toEntity(categoryBodyDto)
                        )
                )
        );
    }

    @Override
    public CategorySavedDto update(Long id, CategoryBodyDto categoryBodyDto) {
        return categoryMapper.toSavedDto(
                categoryRepository.save(
                        fillFieldsForUpdate(
                                categoryMapper.updateEntity(
                                        categoryRepository.findById(id).orElse(new Category()),
                                        categoryBodyDto)
                        )
                )
        );
    }

    @Override
    public CategorySavedDto disable(Long id) {
        return categoryMapper.toSavedDto(
                categoryRepository.save(
                        fillFieldsForDisable(
                                categoryRepository
                                        .findById(id)
                                        .orElse(new Category())
                        )
                )
        );
    }

    private Category fillFieldsForCreate(Category category) {
        category.setState(State.ENABLED.getValue());
        category.setCreatedAt(LocalDateTime.now());
        return category;
    }

    private Category fillFieldsForUpdate(Category category) {
        category.setUpdatedAt(LocalDateTime.now());
        return category;
    }

    private Category fillFieldsForDisable(Category category) {
        category.setState(State.DISABLED.getValue());
        return category;
    }

}