package com.project.osa.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.osa.dto.ProductDto;
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
import java.util.List;

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
        return new ResponseEntity<>(this.productService.addProduct(productDto, image), HttpStatus.CREATED);
    }

    @GetMapping("/getProductImage/{productId}")
    public ResponseEntity<byte[]> getProductImg(@PathVariable Integer productId) {
        Product product = productService.getProductById(productId);

        if (product == null) {
            return ResponseEntity.notFound().build();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        headers.setContentLength(product.getImage().length);

        return new ResponseEntity<>(product.getImage(), headers, HttpStatus.OK);
    }

    @GetMapping("/getProductData/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer productId) {
        return new ResponseEntity<>(productService.getProductById(productId), HttpStatus.OK);
    }

    @GetMapping("/getAllProducts")
    public ResponseEntity<List<Product>> listAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }
}
