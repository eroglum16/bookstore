package com.bookstore.api.repository;

import com.bookstore.api.model.entity.Book;
import com.bookstore.api.model.entity.Cart;
import com.bookstore.api.model.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByCart(Cart cart);

    Optional<CartItem> findByCartAndBook(Cart cart, Book book);
}
