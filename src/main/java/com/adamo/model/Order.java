package com.adamo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @JsonProperty("order_id")
    private String orderId;
    private Customer customer;
    private List<Item> items;
    @JsonProperty("order_date")
    private String orderDate;
    private String status;
    private Payment payment;
    private Shipping shipping;
}
