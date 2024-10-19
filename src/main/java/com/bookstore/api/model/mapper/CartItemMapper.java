package com.bookstore.api.model.mapper;

import com.bookstore.api.model.dto.CartItemDTO;
import com.bookstore.api.model.entity.CartItem;

import java.util.List;

public class CartItemMapper {
    public static List<CartItemDTO> toDtoList(List<CartItem> cartItems){
        return cartItems
                .stream()
                .map(cartItem -> CartItemDTO.builder()
                    .id(cartItem.getId())
                    .book(BookMapper.toDto(cartItem.getBook()))
                    .quantity(cartItem.getQuantity())
                    .build())
                .toList();
    }
}
