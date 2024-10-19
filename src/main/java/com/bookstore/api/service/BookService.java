package com.bookstore.api.service;

import com.bookstore.api.model.dto.BookDTO;

import java.util.List;

public interface BookService {
    List<BookDTO> getAll();
}
