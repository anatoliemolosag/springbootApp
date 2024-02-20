package com.example.springbootApp.customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "api/v1/customer")
@RestController
@Deprecated
public class CustomerControllerV1 {

    private final CustomerService customerService ;

    @Autowired
    public CustomerControllerV1(CustomerService customerService) {
     this.customerService = customerService;
    }

    @GetMapping(value = "all")
    List<Customer> getCustomer(){
        return customerService.getCustomers();
    }

    @PostMapping
    void  createNewCustomer(@RequestBody Customer customer){
        System.out.println("POST REQUEST...");
        System.out.println(customer);
    }

    @DeleteMapping(path = "{customerId}")
    void deleteCustomer(@PathVariable("customerId") Long id){
        System.out.println("DELETE REQUEST FOR CUSTOMER ID " + id);
    }

    @PutMapping
    void updateCustomer(@RequestBody Customer customer){
        System.out.println("PUT REQUEST...");
        System.out.println(customer);
    }
}
