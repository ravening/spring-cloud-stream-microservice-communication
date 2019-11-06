package com.rakeshv.orderservice.controllers;

import com.rakeshv.orderservice.models.Order;
import com.rakeshv.orderservice.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * OrderController
 */
@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public void sendMessage() {
        Order order = Order.builder().name("rakesh").build();
        orderService.send(order);
    }
}