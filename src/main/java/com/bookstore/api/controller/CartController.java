package com.bookstore.api.controller;

import com.bookstore.api.model.dto.AddBookToCartRequest;
import com.bookstore.api.model.dto.CartItemDTO;
import com.bookstore.api.model.dto.ChangeQuantityInCartRequest;
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
    public ResponseEntity<List<CartItemDTO>> getUserCartItems(Principal principal){
        List<CartItemDTO> cartItems = cartService.getCartItems(principal.getName());
        return new ResponseEntity<>(cartItems, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CartItemDTO> addBookToCart(@Valid @RequestBody AddBookToCartRequest request, Principal principal){
        request.setUsername(principal.getName());
        CartItemDTO cartItem = cartService.addBookToCart(request);
        return new ResponseEntity<>(cartItem, HttpStatus.OK);
    }

    @DeleteMapping("/book/{bookId}")
    public ResponseEntity<String> removeBookFromCart(@PathVariable("bookId") Long bookId, Principal principal){
        cartService.removeBookFromCart(bookId, principal.getName());
        return ResponseEntity.ok("Book removed from cart");
    }

    @PutMapping("/book/{bookId}")
    public ResponseEntity<String> changeQuantityInCart(@PathVariable("bookId") Long bookId, @RequestParam Integer quantity, Principal principal){
        ChangeQuantityInCartRequest request = ChangeQuantityInCartRequest.builder()
                .username(principal.getName())
                .bookId(bookId)
                .quantity(quantity)
                .build();
        cartService.changeQuantityInCart(request);
        return ResponseEntity.ok("Quantity changed in cart");
    }
}
