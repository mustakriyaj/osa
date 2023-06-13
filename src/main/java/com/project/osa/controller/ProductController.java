package com.project.osa.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.osa.dto.ProductDto;
import com.project.osa.model.Category;
import com.project.osa.model.Product;
import com.project.osa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class ProductController {

    @Autowired
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/addProduct")
    public ResponseEntity<Product> addProduct(@RequestPart("image") MultipartFile image,
                                              @RequestPart("data") String data) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ProductDto productDto = objectMapper.readValue(data, ProductDto.class);
        return ResponseEntity.ok(this.productService.addProduct(productDto, image));
    }

    @GetMapping("/getProductImage/{productId}")
    public ResponseEntity<byte[]> getProduct(@PathVariable Integer productId) {
        Product product = productService.getProductById(productId);

        if (product == null) {
            return ResponseEntity.notFound().build();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        headers.setContentLength(product.getImage().length);

        return new ResponseEntity<>(product.getImage(), headers, HttpStatus.OK);
    }
}
