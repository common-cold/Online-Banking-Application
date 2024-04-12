package com.example.onlinebankingapplication.service;

import com.example.onlinebankingapplication.entity.Customer;

import java.util.Optional;

public interface CustomerService {
    Customer saveCustomer(Customer customer);

    Optional<Customer> findByCustomerId(Long customerId);
}
