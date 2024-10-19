package com.bookstore.api.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 100)
    private String title;

    @NotNull
    @Size(max = 50)
    private String authorName;

    @NotNull
    @Min(0)
    private BigDecimal price;

    @NotNull
    @Size(min = 13, max = 13)
    private String isbn;

    private String coverImageUrl;
}
