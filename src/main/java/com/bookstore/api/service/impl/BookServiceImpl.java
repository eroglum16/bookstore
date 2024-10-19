package com.bookstore.api.service.impl;

import com.bookstore.api.model.dto.BookDTO;
import com.bookstore.api.model.entity.Book;
import com.bookstore.api.model.mapper.BookMapper;
import com.bookstore.api.repository.BookRepository;
import com.bookstore.api.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public List<BookDTO> getAll() {
        List<Book> books = bookRepository.findAll();
        return BookMapper.toDtoList(books);
    }
}
