package com.bookstore.api.service;

import com.bookstore.api.model.entity.OrderItem;

import java.math.BigDecimal;
import java.util.List;

public interface OrderPriceCalculator {
    BigDecimal calculateTotalPrice(List<OrderItem> orderItems);
}
