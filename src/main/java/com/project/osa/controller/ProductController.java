package com.project.osa.controller;

import com.project.osa.dto.ProductDto;
import com.project.osa.model.Category;
import com.project.osa.model.Product;
import com.project.osa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/addProduct")
    public ResponseEntity<Product> addProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok(this.productService.addProduct(productDto));
    }
}
