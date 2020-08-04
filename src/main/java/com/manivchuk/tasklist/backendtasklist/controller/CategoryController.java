package com.manivchuk.tasklist.backendtasklist.controller;

import com.manivchuk.tasklist.backendtasklist.entity.Category;
import com.manivchuk.tasklist.backendtasklist.repo.CategoryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/test")
    public List<Category> test(){
        return categoryRepository.findAll();
    }
}
