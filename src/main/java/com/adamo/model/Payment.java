package com.adamo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Payment {
    private String paymentId;
    private String method;
    private double totalAmount;
    private String currency;
    private String status;
}
