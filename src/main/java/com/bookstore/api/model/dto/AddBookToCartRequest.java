package com.bookstore.api.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AddBookToCartRequest {
    @NotNull
    private Long bookId;

    @NotNull
    @Min(1)
    private Integer quantity;

    private String username;
}
