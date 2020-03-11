package com.example.customermanagerserver;

import com.example.customermanagerserver.model.*;
import com.example.customermanagerserver.repo.ContractRepo;
import com.example.customermanagerserver.repo.CustomerRepo;
import com.google.common.collect.Lists;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Start {

    private CustomerRepo customerRepo;
    private ContractRepo contractRepo;
    private Categories categories;

    public Start(CustomerRepo customerRepo, ContractRepo contractRepo, Categories categories) {
        this.customerRepo = customerRepo;
        this.contractRepo = contractRepo;
        this.categories = categories;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        Customer customer1 = new Customer(1L, "Jan Nowak", "http://localhost:8080/img/face-facial-hair-fine-looking-guy-614810.jpg", "mało ważny", 24, new Address("Lublin", "Nowa", 3), CustomerType.Standard.getValue(), categories.getCategories());
        Customer customer2 = new Customer(2L, "Adam Słomka", "http://localhost:8080/img/man-in-red-jacket-1681010.jpg", "ważny", 36, new Address("Lublin", "Centralna", 6), CustomerType.Premium.getValue(), categories.getCategories());
        Customer customer3 = new Customer(3L, "Zenon Bąk", "http://localhost:8080/img/adult-beard-boy-casual-220453.jpg", "bardzo ważny", 41, new Address("Warszawa", "Dworcowa", 78), CustomerType.VIP.getValue(), categories.getCategories());
        Customer customer4 = new Customer(4L, "Roman Wilk", "http://localhost:8080/img/man-in-black-shirt-35065.jpg", "kluczowy", 55, new Address("Londyn", "BakerStr.", 9), CustomerType.Standard.getValue(), categories.getCategories());

        customerRepo.setCustomers(Lists.newArrayList(customer1, customer2, customer3, customer4));

        Contract contract1 = new Contract(1L, customer1.getName(), customer1.getId(), 1234.0, LocalDate.of(2020, 01, 12));

        Contract contract2 = new Contract(2L, customer2.getName(), customer2.getId(), 2300.0, LocalDate.of(2019, 12, 23));
        Contract contract3 = new Contract(2L, customer3.getName(), customer3.getId(), 2367.90, LocalDate.of(2019, 11, 25));

        contractRepo.getContracts().addAll(Lists.newArrayList(contract1, contract2, contract3));
    }
}
