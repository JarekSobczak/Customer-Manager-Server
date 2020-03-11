package com.example.customermanagerserver.controllers;

import com.example.customermanagerserver.model.Contract;
import com.example.customermanagerserver.repo.ContractRepo;
import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(MockitoJUnitRunner.class)
public class ContractControllerTest {

    @Mock
    private ContractRepo repo;

    private ContractController controller;

    @Before
    public void setUp() {
        controller = new ContractController(repo);
    }

    @Test
    public void shouldReturnContractList() {
        //given
        Contract contract = new Contract(1L, null, null, null, null);
        ArrayList<Contract> expected = Lists.newArrayList(contract);
        Mockito.when(repo.getContracts()).thenReturn(expected);
        //when
        List<Contract> result = controller.getContracts().getBody();
        //then
        Mockito.verify(repo, Mockito.atLeastOnce()).getContracts();
        assertEquals(expected, result);
    }

    @Test
    public void shouldReturnDifferentContractList() {
        //given
        Contract contract = new Contract(1L, null, null, null, null);
        ArrayList<Contract> expected = Lists.newArrayList(contract);
        Mockito.when(repo.getContracts()).thenReturn(Lists.newArrayList(new Contract(2L, "wzzzz", null, null, null)));
        //when
        List<Contract> result = controller.getContracts().getBody();
        //then
        Mockito.verify(repo, Mockito.atLeastOnce()).getContracts();
        assertNotEquals(expected, result);
    }

    @Test
    public void shouldReturnExpectedContractObject() {
        //given
        Contract expected = new Contract(1L, null, null, null, null);
        ArrayList<Contract> list = Lists.newArrayList(expected);
        Mockito.when(repo.getContracts()).thenReturn(list);
        //when
        Contract result = controller.getOne(1L).getBody();
        //then
        Mockito.verify(repo, Mockito.atLeastOnce()).getContracts();
        assertEquals(expected, result);
    }

    @Test
    public void shouldReturnDifferentContractObject() {
        //given
        Contract expected = new Contract(1L, null, null, null, null);
        ArrayList<Contract> list = Lists.newArrayList(new Contract(2L, null, null, null, null), expected);
        Mockito.when(repo.getContracts()).thenReturn(list);
        //when
        Contract result = controller.getOne(2L).getBody();
        //then
        Mockito.verify(repo, Mockito.atLeastOnce()).getContracts();
        assertNotEquals(expected, result);
    }
}
