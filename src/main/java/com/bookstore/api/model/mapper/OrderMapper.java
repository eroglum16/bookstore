package com.bookstore.api.model.mapper;

import com.bookstore.api.model.dto.OrderDTO;
import com.bookstore.api.model.entity.Order;

public class OrderMapper {
    public static OrderDTO toDto (Order order){
        return OrderDTO.builder()
                .id(order.getId())
                .orderItems(OrderItemMapper.toDtoList(order.getOrderItems()))
                .totalPrice(order.getTotalPrice())
                .address(order.getAddress())
                .build();
    }
}
