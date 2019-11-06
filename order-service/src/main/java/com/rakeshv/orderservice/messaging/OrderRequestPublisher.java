package com.rakeshv.orderservice.messaging;

import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * OrderRequestPublisher
 */
@EnableBinding(OrderRequestBinding.class)
public class OrderRequestPublisher {    
}