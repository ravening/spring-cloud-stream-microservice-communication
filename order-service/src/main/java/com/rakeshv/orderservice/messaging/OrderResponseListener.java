package com.rakeshv.orderservice.messaging;

import com.rakeshv.orderservice.models.Order;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import lombok.extern.slf4j.Slf4j;

/**
 * OrderResponseListener
 */
@EnableBinding(OrderResponsebinding.class)
@Slf4j
public class OrderResponseListener {

    @StreamListener(target = OrderResponsebinding.QUEUE)
    public void processOrderResponse(Order order) {
        log.info("Received back the order response : {}", order);
    }
}