package com.rakeshv.orderservice.messaging;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * OrderRequestBinding
 */
public interface OrderRequestBinding {
    String QUEUE = "order-request";

    @Output(QUEUE)
    MessageChannel orderRequest();
}