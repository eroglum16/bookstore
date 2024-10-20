package com.bookstore.api.controller;

import com.bookstore.api.model.dto.OrderRequest;
import com.bookstore.api.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.security.Principal;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<String> createOrder(@Valid @RequestBody OrderRequest orderRequest, Principal principal){
        orderService.createOrder(principal.getName(), orderRequest.getAddress());
        return ResponseEntity.status(201).body("Order has been successfully created.");
    }
}
