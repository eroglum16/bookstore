package com.bookstore.api.controller;

import com.bookstore.api.model.dto.CartItemDTO;
import com.bookstore.api.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
