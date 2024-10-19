package com.bookstore.api.service;

import com.bookstore.api.model.dto.AddBookToCartRequest;
import com.bookstore.api.model.dto.CartItemDTO;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface CartService {
    List<CartItemDTO> getCartItems(String username);
    void addBookToCart(AddBookToCartRequest request);
}
