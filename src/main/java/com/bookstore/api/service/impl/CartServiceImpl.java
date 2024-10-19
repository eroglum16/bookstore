package com.bookstore.api.service.impl;

import com.bookstore.api.model.dto.CartItemDTO;
import com.bookstore.api.model.entity.Cart;
import com.bookstore.api.model.entity.User;
import com.bookstore.api.model.mapper.CartItemMapper;
import com.bookstore.api.repository.CartRepository;
import com.bookstore.api.repository.UserRepository;
import com.bookstore.api.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final UserRepository userRepository;

    @Override
    public List<CartItemDTO> getCartItems(String username) {
        Cart cart = cartRepository.findByUserUsername(username);
        if (cart == null){
            User user = userRepository.findUserByUsername(username);

            cart = new Cart();
            cart.setUser(user);
            cartRepository.save(cart);
            return new ArrayList<>();
        }
        return CartItemMapper.toDtoList(cart.getCartItems());
    }
}
