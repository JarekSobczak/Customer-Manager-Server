package com.example.customermanagerserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Address {
    private String city;
    private String street;
    private int number;
}
