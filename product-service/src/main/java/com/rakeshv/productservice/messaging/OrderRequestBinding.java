package com.rakeshv.productservice.messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * OrderRequestBinding
 */
public interface OrderRequestBinding {

    String QUEUE = "order-request";

    @Input(QUEUE)
    SubscribableChannel recieveOrder();
}