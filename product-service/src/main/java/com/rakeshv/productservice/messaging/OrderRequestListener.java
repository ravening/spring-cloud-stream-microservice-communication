package com.rakeshv.productservice.messaging;

import com.rakeshv.productservice.models.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import lombok.extern.slf4j.Slf4j;

/**
 * OrderRequestListener
 */
@EnableBinding(OrderRequestBinding.class)
@Slf4j
public class OrderRequestListener {
    @Autowired
    private OrderResponseBinding responseSender;

    @StreamListener(target = OrderRequestBinding.QUEUE)
    public void processReceivedOrder(Order order) {
        log.info("Received order in products service: {}", order);
        log.info("Please wait while we process the order");

        try {
            Thread.sleep(2000);
        } catch (Exception e) {}

        order.setName(order.getName().toUpperCase() + "-PRODUCTS");
        log.info("Sending the response back from products service: {}", order);
        Message<Order> message = MessageBuilder.withPayload(order).build();
        responseSender.orderResponse().send(message);
    }
}