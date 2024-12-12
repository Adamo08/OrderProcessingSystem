package com.adamo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shipping {
    @JsonProperty("shipping_id")
    private int shippingId;
    private String method;
    @JsonProperty("tracking_number")
    private String trackingNumber;
    @JsonProperty("estimated_delivery")
    private String estimatedDelivery;
}
