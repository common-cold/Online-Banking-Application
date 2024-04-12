package com.example.onlinebankingapplication.service;

import com.example.onlinebankingapplication.entity.Account;
import com.example.onlinebankingapplication.entity.Customer;
import com.example.onlinebankingapplication.entity.Transaction;
import com.example.onlinebankingapplication.repository.AccountRepository;
import com.example.onlinebankingapplication.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountServiceImpl accountServiceImpl;


    @Override
    public Transaction createTransaction(Long customerId, Transaction transaction) {
        Optional<Customer> customer = customerService.findByCustomerId(customerId);
        Customer findCustomer = customer.get();
        //TODO handle error
        Account account = accountRepository.findByCustomer(findCustomer);
        transaction.setAccount(account);
        transaction.setRunningBalance(updateRunningBalance(transaction));
        transaction.getAccount().setBalance(transaction.getRunningBalance());
        transaction.setTransactionDate(accountServiceImpl.setCurrentDate());
        transactionRepository.save(transaction);
        return transaction;
    }


    public Long updateRunningBalance(Transaction transaction){
        Long balance = transaction.getAccount().getBalance();
        Long creditAmount = transaction.getCreditAmount();
        Long debitAmount = transaction.getDebitAmount();
        if(creditAmount!=0 || debitAmount!=0){
            if(debitAmount!=0){
                balance = balance - debitAmount;
            }
            else{
                balance = balance + creditAmount;
            }
        }
        return balance;
    }
}
