package com.bookstore.api.repository;

import com.bookstore.api.model.entity.Cart;
import com.bookstore.api.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findByUser(User user);
}
