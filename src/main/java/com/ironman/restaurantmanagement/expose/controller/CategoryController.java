package com.ironman.restaurantmanagement.expose.controller;

import com.ironman.restaurantmanagement.application.dto.category.CategoryBodyDto;
import com.ironman.restaurantmanagement.application.dto.category.CategoryDto;
import com.ironman.restaurantmanagement.application.dto.category.CategorySavedDto;
import com.ironman.restaurantmanagement.application.dto.category.CategorySmallDto;
import com.ironman.restaurantmanagement.application.service.CategoryService;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


// Spring annotations
@RequiredArgsConstructor

// Spring Stereotype annotation
@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<CategorySmallDto> getCategories() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public CategoryDto findById(@PathVariable("id") Long id) {
        return categoryService.findById(id);
    }

    @GetMapping("/state/{state}")
    public List<CategorySmallDto> findByState(@PathVariable("state") String state) {
        return categoryService.findByState(state);
    }

    @PostMapping
    public CategorySavedDto create(@RequestBody CategoryBodyDto categoryBodyDto) {
        return categoryService.create(categoryBodyDto);
    }

    @PatchMapping("/{id}")
    public CategorySavedDto update(@PathVariable("id") Long id, @RequestBody CategoryBodyDto categoryBodyDto) {
        return categoryService.update(id, categoryBodyDto);
    }

    @DeleteMapping("/{id}")
    public CategorySavedDto disable(@PathVariable("id") Long id) {
        return categoryService.disable(id);
    }

}