package com.example.onlinebankingapplication.service;

import com.example.onlinebankingapplication.entity.Account;
import com.example.onlinebankingapplication.entity.Transaction;

import java.util.List;

public interface AccountService {
    Account createAccount(Long customerId, Account account);

    Long checkBalance(Long customerId);

    void updateAccount(Account account);

    List<Transaction> showTransactions(Long customerId);
}
