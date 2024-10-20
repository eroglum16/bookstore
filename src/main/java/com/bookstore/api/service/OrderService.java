package com.bookstore.api.service;

import com.bookstore.api.model.dto.OrderDTO;

public interface OrderService {
    OrderDTO createOrder(String username, String address);
}
