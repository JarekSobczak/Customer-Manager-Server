package com.example.customermanagerserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class Customer {
    private Long id;
    private String name;
    private String photoUrl;
    private String description;
    private int age;
    private Address address;
    private int type;
    private List<String>categories;
}
