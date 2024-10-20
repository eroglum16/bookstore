package com.bookstore.api.repository;

import com.bookstore.api.model.entity.Book;
import com.bookstore.api.model.entity.Cart;
import com.bookstore.api.model.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByCart(Cart cart);
    Optional<CartItem> findByCartAndBook(Cart cart, Book book);
    List<CartItem> deleteByCart(Cart cart);
}
