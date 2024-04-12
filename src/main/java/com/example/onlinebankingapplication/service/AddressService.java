package com.example.onlinebankingapplication.service;

import com.example.onlinebankingapplication.entity.Address;

public interface AddressService {
    void saveAddress(Long customerId, Address address);
}
