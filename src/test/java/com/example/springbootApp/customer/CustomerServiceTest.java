package com.example.springbootApp.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerServiceTest {

    @Autowired
    private CustomerRepository customerRepository;
    private CustomerService underTest;
    @BeforeEach
    void setUp() {
        underTest = new CustomerService(customerRepository);
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }

    @Test
    void getCustomers() {

        //Given
        Customer anatolie = new Customer(1L,"Anatolie","hello","anatolie94@gmail.com");
        Customer george = new Customer(2L,"George","hello","george99@gmail.com");
        customerRepository.saveAll(Arrays.asList(anatolie,george));

        //When
        List<Customer> customers = underTest.getCustomers();

        //Then
        assertEquals(2,customers.size());
    }

    @Test
    void getCustomer() {

        //Given
        Customer anatolie = new Customer(1L,"Anatolie","hello","anatolie94@gmail.com");
        customerRepository.save(anatolie);

        //When
        Customer actual = underTest.getCustomer(1L);

        //Then
        assertEquals(1L,actual.getId());
        assertEquals("Anatolie",actual.getName());
        assertEquals("hello",actual.getPassword());
        assertEquals("anatolie94@gmail.com",actual.getEmail());
    }
}