package com.example.onlinebankingapplication.service;

import com.example.onlinebankingapplication.entity.Contact;
import com.example.onlinebankingapplication.entity.Customer;
import com.example.onlinebankingapplication.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService{

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private CustomerService customerService;

    @Override
    public void saveContact(Long customerId, Contact contact) {
        Optional<Customer> customer = customerService.findByCustomerId(customerId);
        //TODO
        contact.setCustomer(customer.get());
        contactRepository.save(contact);
    }
}
