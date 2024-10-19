package com.tutorial.Relation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.Relation.model.Category;
import com.tutorial.Relation.model.CategoryDTO;
import com.tutorial.Relation.serviceInterface.CategoryService;

@RestController
@RequestMapping("/api/category/")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("findAll")
    public List<CategoryDTO> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping("addCategory")
    public ResponseEntity<?> createCategory(@RequestBody Category category) {
        
    	return ResponseEntity.ok(categoryService.createCategory(category));
    }
}
