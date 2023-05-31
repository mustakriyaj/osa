package com.project.osa.controller;

import com.project.osa.model.Category;
import com.project.osa.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/addCategory")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        return ResponseEntity.ok(this.categoryService.addCategory(category));
    }

    @GetMapping("/showAllCategory")
    public ResponseEntity<List<Category>> showAllCategory() {
        List<Category> temp = this.categoryService.showAllCategory();
        return ResponseEntity.ok(temp);
    }
}
