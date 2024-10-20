package com.bookstore.api.service;

import com.bookstore.api.model.dto.AddBookToCartRequest;
import com.bookstore.api.model.dto.CartItemDTO;
import com.bookstore.api.model.dto.ChangeQuantityInCartRequest;
import com.bookstore.api.model.entity.Cart;

import java.util.List;
import java.util.Optional;

public interface CartService {
    List<CartItemDTO> getCartItems(String username);
    CartItemDTO addBookToCart(AddBookToCartRequest request);
    void removeBookFromCart(Long bookId, String username);
    void changeQuantityInCart(ChangeQuantityInCartRequest request);
    Optional<Cart> getCartByUsername(String username);
    void emptyCart(String username);
}
