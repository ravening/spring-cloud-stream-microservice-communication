package com.rakeshv.orderservice.service;

import com.rakeshv.orderservice.messaging.OrderRequestBinding;
import com.rakeshv.orderservice.models.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * OrderService
 */
@Service
@Slf4j
public class OrderService {
    @Autowired
    private OrderRequestBinding orderRequest;

    public boolean send(Order order) {
        log.info("Sending the order: {}", order);
        Message<Order> message = MessageBuilder.withPayload(order).build();
        return orderRequest.orderRequest().send(message);
    }
}