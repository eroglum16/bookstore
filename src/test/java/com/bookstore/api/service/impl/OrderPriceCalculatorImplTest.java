package com.bookstore.api.service.impl;

import com.bookstore.api.model.entity.Book;
import com.bookstore.api.model.entity.OrderItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class OrderPriceCalculatorImplTest {
    @InjectMocks
    private OrderPriceCalculatorImpl orderPriceCalculator;

    private static List<OrderItem> orderItems;
    private static BigDecimal testTotalPrice;
    @BeforeAll
    static void setUp() {
        orderItems = new ArrayList<>();

        Book book1 = new Book();
        book1.setPrice(new BigDecimal(12));

        Book book2 = new Book();
        book2.setPrice(new BigDecimal("18.5"));

        OrderItem orderItem1 = new OrderItem();
        orderItem1.setBook(book1);
        orderItem1.setQuantity(2);
        orderItems.add(orderItem1);
        // Total price for item: 24

        OrderItem orderItem2 = new OrderItem();
        orderItem2.setBook(book2);
        orderItem2.setQuantity(1);
        orderItems.add(orderItem2);
        // Total price for item: 18.5

        // Total price: 42.5
        testTotalPrice = new BigDecimal("42.5");
    }

    @Test
    void calculateTotalPrice_TheResultIsCorrect(){
        BigDecimal totalPrice = orderPriceCalculator.calculateTotalPrice(orderItems);
        Assertions.assertEquals(totalPrice, testTotalPrice);
    }

}
