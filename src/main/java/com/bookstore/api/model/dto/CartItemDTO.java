package com.bookstore.api.model.dto;

import jakarta.validation.constraints.Min;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class CartItemDTO {
    private Long id;

    private BookDTO book;

    @Min(0)
    private Integer quantity;
}
