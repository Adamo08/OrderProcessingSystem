package com.adamo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    @JsonProperty("payment_id")
    private String paymentId;

    private String method;

    @JsonProperty("total_amount")
    private double totalAmount;

    private String currency;
    private String status;
}
