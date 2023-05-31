package com.project.osa.service;

import com.project.osa.dto.ProductDto;
import com.project.osa.model.Category;
import com.project.osa.model.Product;
import com.project.osa.repository.CategoryRepository;
import com.project.osa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private final ProductRepository productRepository;

    @Autowired
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public Product addProduct(ProductDto productDto) {
        Optional<Category> optionalCategory = this.categoryRepository.findById(productDto.getCategoryId());
        Category category = optionalCategory.get();
        Product productTemp = new Product();
        productTemp.setProductName(productDto.getProductName());
        productTemp.setPrice(productDto.getPrice());
        productTemp.setManufacturer(productDto.getManufacturer());
        productTemp.setCategory(category);
        return this.productRepository.save(productTemp);
    }
}
