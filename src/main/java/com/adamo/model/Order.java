package com.adamo.model;

import lombok.Data;

import java.util.List;

@Data
public class Order {
    private String orderId;
    private Customer customer;
    private List<Item> items;
    private String orderDate;
    private String status;
    private Payment payment;
    private Shipping shipping;
}
