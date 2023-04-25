package com.project.osa.service;

import com.project.osa.model.Category;
import com.project.osa.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private final CategoryRepository categoryRepository;


    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category addCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    public List<Category> showAllCategory() {
        return this.categoryRepository.findAll();
    }
}
