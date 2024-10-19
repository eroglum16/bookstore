package com.bookstore.api.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.security.Principal;

@Data
public class AddBookToCartRequest {
    @NotNull
    Long bookId;

    @NotNull
    @Min(1)
    Integer quantity;

    String username;
}
