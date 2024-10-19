package com.bookstore.api.controller;

import com.bookstore.api.model.dto.AddBookToCartRequest;
import com.bookstore.api.model.dto.CartItemDTO;
import com.bookstore.api.service.CartService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @GetMapping
    public ResponseEntity<List<CartItemDTO>>getUserCartItems(Principal principal){
        List<CartItemDTO> cartItems = cartService.getCartItems(principal.getName());
        return new ResponseEntity<>(cartItems, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String>addBookToCart(@Valid @RequestBody AddBookToCartRequest request, Principal principal){
        request.setUsername(principal.getName());
        cartService.addBookToCart(request);
        return ResponseEntity.ok("Book added successfully!");
    }
}
