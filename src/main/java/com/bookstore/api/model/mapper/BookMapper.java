package com.bookstore.api.model.mapper;

import com.bookstore.api.model.dto.BookDTO;
import com.bookstore.api.model.entity.Book;

import java.util.List;

public class BookMapper {
    public static List<BookDTO> toDtoList(List<Book> books){
        return books.stream().map(book -> {
            return BookDTO.builder()
                    .id(book.getId())
                    .title(book.getTitle())
                    .authorName(book.getAuthorName())
                    .price(book.getPrice())
                    .isbn(book.getIsbn())
                    .coverImageUrl(book.getCoverImageUrl())
                    .build();
        }).toList();
    }
}
