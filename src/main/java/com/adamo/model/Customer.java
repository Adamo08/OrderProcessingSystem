package com.adamo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {
    private String customerId;
    private String name;
    private String email;
    private String phone;
    private Address address;
}

