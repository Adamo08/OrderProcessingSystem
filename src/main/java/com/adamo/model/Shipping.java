package com.adamo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Shipping {
    private String method;
    private String trackingNumber;
    private String estimatedDelivery;
}
