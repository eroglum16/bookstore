package com.bookstore.api.model.dto;

import com.bookstore.api.model.entity.CartItem;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Setter
@Getter
public class CartDTO {
    private Long id;
    private List<CartItem> cartItems;
}
