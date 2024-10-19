package com.bookstore.api.model.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ChangeQuantityInCartRequest {
    private Long bookId;
    private String username;
    private Integer quantity;
}
