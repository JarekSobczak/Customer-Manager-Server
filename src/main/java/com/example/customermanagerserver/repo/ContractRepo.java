package com.example.customermanagerserver.repo;

import com.example.customermanagerserver.model.Contract;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Data
public class ContractRepo {

    private List<Contract> contracts;
}

