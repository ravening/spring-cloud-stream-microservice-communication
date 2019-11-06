package com.rakeshv.accountservice.messaging;

import com.rakeshv.accountservice.models.Order;

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
    private OrderResponseBinding orderResponse;

    @StreamListener(target = OrderRequestBinding.QUEUE)
    public void processRecivedOrder(Order order) {
        log.info("received order in accounts service : {}", order);  

        log.info("Please wait while we process the order");
        try {
            Thread.sleep(2000);
        } catch (Exception e) {}

        order.setName(order.getName().toUpperCase() + "-accounts");
        log.info("sending the response back from accounts: {}", order);
        Message<Order> message = MessageBuilder.withPayload(order).build();
        orderResponse.orderResponse().send(message);
    }
}