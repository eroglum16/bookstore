package com.bookstore.api.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "book_id")
    @ManyToOne(targetEntity = Book.class, fetch = FetchType.LAZY)
    @JsonBackReference
    private Book book;

    @JoinColumn(name = "cart_id")
    @ManyToOne(targetEntity = Cart.class, fetch = FetchType.LAZY)
    @JsonBackReference
    private Cart cart;

    private Integer quantity;
}
