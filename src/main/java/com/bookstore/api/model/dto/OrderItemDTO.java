package com.bookstore.api.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderItemDTO {
    private Long id;
    private BookDTO book;
    private OrderDTO order;
    private Integer quantity;
}
