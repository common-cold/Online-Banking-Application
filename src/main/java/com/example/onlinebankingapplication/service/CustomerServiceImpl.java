package com.example.onlinebankingapplication.service;

import com.example.onlinebankingapplication.entity.Customer;
import com.example.onlinebankingapplication.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> findByCustomerId(Long customerId) {
        return customerRepository.findById(customerId);
    }
}
