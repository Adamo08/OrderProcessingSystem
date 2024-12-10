package com.adamo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @JsonProperty("customer_id")
    private String customerId;

    private String name;
    private String email;
    private String phone;
    private Address address;

}

