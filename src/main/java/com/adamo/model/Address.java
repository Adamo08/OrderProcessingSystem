package com.adamo.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Address {
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String country;
}

