package com.bookstore.api.service.impl;

import com.bookstore.api.model.dto.CartItemDTO;
import com.bookstore.api.repository.CartRepository;
import com.bookstore.api.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CartServiceImplTest {

    @Mock
    private CartRepository cartRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private CartServiceImpl cartService;

    @Test
    void getCartItems_ShouldReturnNonNullResult() {
        List<CartItemDTO> cartItems = cartService.getCartItems("test");

        Assertions.assertNotNull(cartItems);
    }

}
