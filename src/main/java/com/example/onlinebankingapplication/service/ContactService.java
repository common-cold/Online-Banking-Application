package com.example.onlinebankingapplication.service;

import com.example.onlinebankingapplication.entity.Contact;

public interface ContactService {
    void saveContact(Long customerId, Contact contact);
}
