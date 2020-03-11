package com.example.customermanagerserver.controllers;

import com.example.customermanagerserver.model.Customer;
import com.example.customermanagerserver.repo.CustomerRepo;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerRepo repo;

    public CustomerController(CustomerRepo repo) {
        this.repo = repo;
    }

    @CrossOrigin
    @GetMapping
    public HttpEntity<List<Customer>> getCustomers() {
        return ResponseEntity.ok(repo.getCustomers());
    }

    @CrossOrigin
    @PostMapping
    public void addCustomer(@RequestBody Customer customer) {
        repo.getCustomers().add(customer);
    }

    @CrossOrigin
    @DeleteMapping("/{name}")
    public void deleteCustomer(@PathVariable String name) {
        Customer deletingCustomer = repo.getCustomers().stream().filter(customer -> customer.getName().equalsIgnoreCase(name))
                .findFirst().get();
        repo.getCustomers().remove(deletingCustomer);
    }
}
