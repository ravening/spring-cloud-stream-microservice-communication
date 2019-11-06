package com.rakeshv.productservice.messaging;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * OrderResponseBinding
 */
public interface OrderResponseBinding {

    @Output("order-response")
    MessageChannel orderResponse();
}