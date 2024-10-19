package com.bookstore.api.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
public class BookDTO {
    private Long id;
    private String title;
    private String authorName;
    private BigDecimal price;
    private String isbn;
    private String coverImageUrl;
}
