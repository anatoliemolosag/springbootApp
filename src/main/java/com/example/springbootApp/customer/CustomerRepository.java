package com.example.springbootApp.customer;

import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class CustomerRepository implements  CustomerRepo{
    @Override
    public List<Customer> getCustomers() {
        //Connect to real database
        return Collections.singletonList(
                new Customer(1L,"TODO. Implement real db","todo", "email@gmail.com")
        );
    }
}
