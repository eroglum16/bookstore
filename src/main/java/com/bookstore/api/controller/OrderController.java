package com.bookstore.api.controller;

import com.bookstore.api.model.dto.OrderDTO;
import com.bookstore.api.model.dto.OrderRequest;
import com.bookstore.api.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(@Valid @RequestBody OrderRequest orderRequest, Principal principal){
        OrderDTO createdOrder = orderService.createOrder(principal.getName(), orderRequest.getAddress());
        return ResponseEntity.status(201).body(createdOrder);
    }
}
