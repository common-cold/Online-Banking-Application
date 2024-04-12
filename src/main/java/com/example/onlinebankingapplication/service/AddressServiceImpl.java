package com.example.onlinebankingapplication.service;

import com.example.onlinebankingapplication.entity.Address;
import com.example.onlinebankingapplication.entity.Customer;
import com.example.onlinebankingapplication.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CustomerService customerService;

    @Override
    public void saveAddress(Long customerId, Address address) {
        Optional<Customer> customer = customerService.findByCustomerId(customerId);
        //TODO
        address.setCustomer(customer.get());
        addressRepository.save(address);
    }
}
