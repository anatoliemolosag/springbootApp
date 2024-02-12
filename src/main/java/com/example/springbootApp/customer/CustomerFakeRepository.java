package com.example.springbootApp.customer;

import java.util.Arrays;
import java.util.List;

//@Repository(value = "fake")
public class CustomerFakeRepository implements CustomerRepo{
    @Override
    public List<Customer> getCustomers() {
        return Arrays.asList(
                new Customer(1L,"Anatolie Molosag","password123456", "email@gmail.com"),
                new Customer(2L,"Roxana Rusu","password123456", "email@gmail.com")
        );
    }
}
