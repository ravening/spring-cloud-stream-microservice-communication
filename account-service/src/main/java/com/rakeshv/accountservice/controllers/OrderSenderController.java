package com.rakeshv.accountservice.controllers;

import com.rakeshv.accountservice.messaging.OrderResponseBinding;
import com.rakeshv.accountservice.models.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * OrderSenderController
 */
@RestController
@RequestMapping("/api/account")
@Slf4j
public class OrderSenderController {
    @Autowired
    private OrderResponseBinding orderResponse;

    @GetMapping
    public void sendResponse() {
        Order order = Order.builder().name("RAKESH").build();

        log.info("sending the response : {}", order);
        Message<Order> message = MessageBuilder.withPayload(order).build();
        orderResponse.orderResponse().send(message);
    }
    
}