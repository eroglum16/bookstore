package com.bookstore.api.controller;

import com.bookstore.api.model.dto.BookDTO;
import com.bookstore.api.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookDTO>>getAllBooks(){
        List<BookDTO> books = bookService.getAll();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
}
