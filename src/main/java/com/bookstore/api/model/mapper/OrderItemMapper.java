package com.bookstore.api.model.mapper;

import com.bookstore.api.model.dto.OrderItemDTO;
import com.bookstore.api.model.entity.OrderItem;

import java.util.List;

public class OrderItemMapper {
    public static List<OrderItemDTO> toDtoList(List<OrderItem> orderItems){
        return orderItems
                .stream()
                .map(orderItem ->
                        OrderItemDTO.builder()
                                .id(orderItem.getId())
                                .book(BookMapper.toDto(orderItem.getBook()))
                                .quantity(orderItem.getQuantity())
                                .build()
                )
                .toList();
    }
}
