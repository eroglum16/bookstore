package com.bookstore.api.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "book_id")
    @ManyToOne(targetEntity = Book.class, fetch = FetchType.LAZY)
    @JsonBackReference
    private Book book;

    @JoinColumn(name = "order_id")
    @ManyToOne(targetEntity = Order.class, fetch = FetchType.LAZY)
    @JsonBackReference
    private Order order;

    private Integer quantity;
}
