package com.example.customermanagerserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
@Data
@AllArgsConstructor
public class Contract {
    private Long id;
    private String customerName;
    private Long customerId;
    private Double value;
    private LocalDate date;
}
