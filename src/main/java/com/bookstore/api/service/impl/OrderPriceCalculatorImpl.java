package com.bookstore.api.service.impl;

import com.bookstore.api.model.entity.OrderItem;
import com.bookstore.api.service.OrderPriceCalculator;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderPriceCalculatorImpl implements OrderPriceCalculator {
    @Override
    public BigDecimal calculateTotalPrice(List<OrderItem> orderItems) {
        return orderItems
                .stream()
                .map(orderItem -> orderItem.getBook().getPrice().multiply(BigDecimal.valueOf(orderItem.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
