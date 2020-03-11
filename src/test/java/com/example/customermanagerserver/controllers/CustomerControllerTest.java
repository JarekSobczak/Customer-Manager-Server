package com.example.customermanagerserver.controllers;

import com.example.customermanagerserver.model.Customer;
import com.example.customermanagerserver.repo.CustomerRepo;
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
public class CustomerControllerTest {

    @Mock
    private CustomerRepo repo;

    private CustomerController controller;

    @Before
    public void setUp() {
        controller = new CustomerController(repo);
    }

    @Test
    public void shouldReturnListOfCustomers() {
        //given
        ArrayList<Customer> expected = Lists.newArrayList(new Customer(1L, null, null, null, 5, null, 1, null));
        Mockito.when(repo.getCustomers()).thenReturn(expected);
        //when
        List<Customer> result = controller.getCustomers().getBody();
        //then
        Mockito.verify(repo, Mockito.atLeastOnce()).getCustomers();
        assertEquals(expected, result);

    }

    @Test
    public void shouldReturnDifferentListOfCustomers() {
        //given
        ArrayList<Customer> expected = Lists.newArrayList(new Customer(1L, null, null, null, 5, null, 1, null));
        Mockito.when(repo.getCustomers()).thenReturn(Lists.newArrayList(new Customer(1L, null, null, null, 7, null, 2, null)));
        //when
        List<Customer> result = controller.getCustomers().getBody();
        //then
        assertNotEquals(expected, result);
    }
}
