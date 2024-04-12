package com.example.onlinebankingapplication.service;

import com.example.onlinebankingapplication.entity.Transaction;

public interface TransactionService {
    Transaction createTransaction(Long customerId, Transaction transaction);
}
