package com.bookstore.api.service;

import com.bookstore.api.model.dto.CartItemDTO;

import java.util.List;

public interface CartService {
    List<CartItemDTO> getCartItems(String username);
}
