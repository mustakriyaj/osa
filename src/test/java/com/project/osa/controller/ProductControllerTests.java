package com.project.osa.controller;

import com.project.osa.controller.ProductController;
import com.project.osa.dto.ProductDto;
import com.project.osa.model.Product;
import com.project.osa.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTests {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddProduct() throws IOException {
        // Mock data
        byte[] imageBytes = {1, 2, 3};
        MultipartFile image = new MockMultipartFile("image", "image.jpg", "image/jpeg", imageBytes);
        String data = "{\"productName\":\"Test Product\",\"price\":\"10.99\",\"manufacturer\":\"Test Manufacturer\",\"categoryId\":1}";

        // Mock service response
        ProductDto productDto = new ProductDto();
        productDto.setProductName("Test Product");
        // Set other productDto properties
        Product savedProduct = new Product();
        savedProduct.setId(1);
        savedProduct.setImage(image.getBytes());
        // Set other savedProduct properties
        Mockito.when(productService.addProduct(any(ProductDto.class), any(MultipartFile.class)))
                .thenReturn(savedProduct);

        // Perform the request
        ResponseEntity<Product> response = productController.addProduct(image, data);

        // Verify the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(1L, response.getBody().getId().longValue());

        // Verify that the service method was called with the correct arguments
        Mockito.verify(productService, Mockito.times(1)).addProduct(any(ProductDto.class),
                any(MultipartFile.class));
    }

    @Test
    public void testGetProductImage() {
        // Mock data
        Integer productId = 1;
        Product product = new Product();
        product.setId(productId);
        byte[] imageBytes = {1, 2, 3};
        product.setImage(imageBytes);
        // Set other product properties

        Mockito.when(productService.getProductById(productId)).thenReturn(product);

        // Perform the request
        ResponseEntity<byte[]> response = productController.getProductImg(productId);

        // Verify the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertArrayEquals(imageBytes, response.getBody());

        // Verify that the service method was called with the correct argument
        Mockito.verify(productService, Mockito.times(1)).getProductById(productId);
    }
}
