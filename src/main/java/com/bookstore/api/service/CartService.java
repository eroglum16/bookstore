package com.bookstore.api.service;

import com.bookstore.api.model.dto.AddBookToCartRequest;
import com.bookstore.api.model.dto.CartItemDTO;
import com.bookstore.api.model.dto.ChangeQuantityInCartRequest;

import java.util.List;

public interface CartService {
    List<CartItemDTO> getCartItems(String username);
    CartItemDTO addBookToCart(AddBookToCartRequest request);
    void removeBookFromCart(Long bookId, String username);
    void changeQuantityInCart(ChangeQuantityInCartRequest request);
}
