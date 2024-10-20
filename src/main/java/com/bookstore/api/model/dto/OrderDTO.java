package com.bookstore.api.model.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class OrderDTO {
    private Long id;
    private UserDTO user;
    private List<OrderItemDTO> orderItems;
    private BigDecimal totalPrice;
    private String address;
}
