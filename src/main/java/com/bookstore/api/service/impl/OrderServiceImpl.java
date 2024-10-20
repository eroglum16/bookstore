package com.bookstore.api.service.impl;

import com.bookstore.api.exception.CartNotFoundException;
import com.bookstore.api.model.entity.*;
import com.bookstore.api.model.mapper.CartItemToOrderItemMapper;
import com.bookstore.api.repository.CartItemRepository;
import com.bookstore.api.repository.OrderItemRepository;
import com.bookstore.api.repository.OrderRepository;
import com.bookstore.api.repository.UserRepository;
import com.bookstore.api.service.CartService;
import com.bookstore.api.service.OrderPriceCalculator;
import com.bookstore.api.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final CartService cartService;
    private final OrderPriceCalculator orderPriceCalculator;

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final CartItemRepository cartItemRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public void createOrder(String username, String address) {
        Optional<Cart> cart = cartService.getCartByUsername(username);
        if (cart.isEmpty()){
            throw new CartNotFoundException("Cart not found for the current user");
        }
        User user = userRepository.findUserByUsername(username);

        List<CartItem> cartItems = cartItemRepository.findByCart(cart.get());
        List<OrderItem> orderItems = CartItemToOrderItemMapper.toOrderItemList(cartItems);
        BigDecimal totalPrice = orderPriceCalculator.calculateTotalPrice(orderItems);

        Order order = Order.builder()
                .user(user)
                .totalPrice(totalPrice)
                .address(address)
                .build();

        orderItems = orderItems
                .stream()
                .map(orderItem -> {
                    orderItem.setOrder(order);
                    return orderItem;
                })
                .toList();
        orderItemRepository.saveAll(orderItems);

        orderRepository.save(order);
        cartService.emptyCart(username);
    }
}
