package com.example.customermanagerserver.repo;

import com.example.customermanagerserver.model.Customer;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Data
public class CustomerRepo {

    private List<Customer> customers;
}

