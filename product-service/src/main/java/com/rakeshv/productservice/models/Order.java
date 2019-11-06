package com.rakeshv.productservice.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Order
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String name;
    
}