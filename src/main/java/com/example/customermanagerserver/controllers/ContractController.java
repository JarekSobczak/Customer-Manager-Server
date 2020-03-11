package com.example.customermanagerserver.controllers;

import com.example.customermanagerserver.model.Contract;
import com.example.customermanagerserver.repo.ContractRepo;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contracts")
public class ContractController {

    private ContractRepo repo;

    public ContractController(ContractRepo repo) {
        this.repo = repo;
    }

    @CrossOrigin
    @GetMapping
    public HttpEntity<List<Contract>> getContracts() {
        return ResponseEntity.ok(repo.getContracts());
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public HttpEntity<Contract> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(repo.getContracts().stream()
                .filter(contract -> contract.getId().equals(id)).findFirst().get());
    }
}
