package com.example.springbootApp.customer;

import com.example.springbootApp.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepo customerRepo;

    @Autowired             // Add parameter @Qualifier("fake") to fake data
    public CustomerService( CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    List<Customer> getCustomers(){
        return customerRepo.getCustomers();
    }

    Customer getCustomer(Long id){
        return getCustomers()
                .stream().
                filter(customer -> customer.getId().equals(id))
                .findFirst()
                .orElseThrow( () -> new NotFoundException("customer with " + id + " not found"));
    }

}
