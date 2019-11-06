package com.rakeshv.accountservice.messaging;

import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * OrderResponsePublisher
 */
@EnableBinding(OrderResponseBinding.class)
public class OrderResponsePublisher {
}