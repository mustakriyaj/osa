package com.project.osa.repository;

import com.project.osa.model.Cart;
import com.project.osa.model.CartItem;
import com.project.osa.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    Cart findByCustomer(Customer customer);
}
