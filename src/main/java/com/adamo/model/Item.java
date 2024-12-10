package com.adamo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @JsonProperty("product_id")
    private String productId;
    @JsonProperty("product_name")
    private String productName;
    private int quantity;
    @JsonProperty("unit_price")
    private double unitPrice;
    @JsonProperty("total_price")
    private double totalPrice;
}
