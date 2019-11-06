package com.rakeshv.orderservice.messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * OrderResponsebinding
 */
public interface OrderResponsebinding {

    String QUEUE = "order-response";

    @Input(QUEUE)
    SubscribableChannel orderResponse();
}