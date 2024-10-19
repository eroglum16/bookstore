package com.bookstore.api.repository;

import com.bookstore.api.model.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByUserUsername(String username);
}
