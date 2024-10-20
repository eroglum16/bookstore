package com.bookstore.api.model.mapper;

import com.bookstore.api.model.entity.CartItem;
import com.bookstore.api.model.entity.OrderItem;

import java.util.List;

public class CartItemToOrderItemMapper {
    public static List<OrderItem> toOrderItemList(List<CartItem> cartItems){
        return cartItems
                .stream()
                .map(cartItem -> {
                    OrderItem orderItem = new OrderItem();
                    orderItem.setBook(cartItem.getBook());
                    orderItem.setQuantity(cartItem.getQuantity());
                    return orderItem;
                })
                .toList();
    }
}
