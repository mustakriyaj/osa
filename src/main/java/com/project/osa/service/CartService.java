package com.project.osa.service;

import com.project.osa.model.Cart;
import com.project.osa.model.CartItem;
import com.project.osa.model.Customer;
import com.project.osa.model.Product;
import com.project.osa.repository.CartItemRepository;
import com.project.osa.repository.CartRepository;
import com.project.osa.repository.CustomerRepository;
import com.project.osa.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    public CartService(CartRepository cartRepository, CartItemRepository cartItemRepository, CustomerRepository customerRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    public Cart addToCart(Integer customerId, Integer productId, int quantity) {
        Customer customer = customerRepository.findById(customerId).get();
        Product product = productRepository.findById(productId).get();
        Cart cart = customer.getCart();
        if (cart == null) {
            cart = new Cart();
            cart.setCustomer(customer);
        }

        CartItem cartItem = findCartItemByProduct(cart, product);
        if (cartItem == null) {
            cartItem = new CartItem();
            cartItem.setCart(cart);
            cartItem.setProduct(product);
            cart.getCartItems().add(cartItem);
        }

        cartItem.setQuantity(cartItem.getQuantity() + quantity);

        return cartRepository.save(cart);
    }

    public Cart removeCartItem(Customer customer, Long cartItemId) {
        Cart cart = customer.getCart();
        if (cart != null) {
            cart.getCartItems().removeIf(item -> item.getId().equals(cartItemId));
            cartRepository.save(cart);
        }
        return cart;
    }

    public List<CartItem> showCart(Integer customerId) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            Cart cart =  cartRepository.findByCustomer(customer);
            return cartItemRepository.findByCart(cart);
        } else {
            throw new IllegalArgumentException("Customer not found");
        }
    }

    private CartItem findCartItemByProduct(Cart cart, Product product) {
        for (CartItem cartItem : cart.getCartItems()) {
            if (cartItem.getProduct().equals(product)) {
                return cartItem;
            }
        }
        return null;
    }
}

