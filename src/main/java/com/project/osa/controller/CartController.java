package com.project.osa.controller;

import com.project.osa.model.Cart;
import com.project.osa.model.CartItem;
import com.project.osa.service.CartService;
import com.project.osa.dto.AddToCartReqestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {

    @Autowired
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/add-to-cart")
    public ResponseEntity<Cart> addToCart(@RequestBody AddToCartReqestDto addToCartRequestDto) {
        Integer customerId = addToCartRequestDto.getCustomerId();
        Integer productId = addToCartRequestDto.getProductId();
        int quantity = addToCartRequestDto.getQuantity();

        Cart cart = cartService.addToCart(customerId, productId, quantity);

        return ResponseEntity.ok(cart);
    }

    @GetMapping("/cart/{customerId}")
    public ResponseEntity<List<CartItem>> showCart(@PathVariable Integer customerId) {
        List<CartItem> cartItems = cartService.showCart(customerId);
        return ResponseEntity.ok(cartItems);
    }
}

