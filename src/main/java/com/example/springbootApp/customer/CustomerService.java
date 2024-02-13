package com.example.springbootApp.customer;

import com.example.springbootApp.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired             // Add parameter @Qualifier("fake") to fake data
    public CustomerService( CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    Customer getCustomer(Long id){
        return customerRepository.findById(id)
                .orElseThrow( () -> new NotFoundException("customer with " + id + " not found"));
    }

}
