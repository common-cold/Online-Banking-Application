package com.example.onlinebankingapplication.service;

import com.example.onlinebankingapplication.entity.Account;
import com.example.onlinebankingapplication.entity.Customer;
import com.example.onlinebankingapplication.entity.Transaction;
import com.example.onlinebankingapplication.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account createAccount(Long customerId, Account account) {
        Optional<Customer> customer = customerService.findByCustomerId(customerId);
        //TODO handle error
        account.setCustomer(customer.get());
        account.setCreateDate(setCurrentDate());
        account.setAccountNo(setRandomAccountNo());
        return accountRepository.save(account);
    }

    @Override
    public Long checkBalance(Long customerId) {
        Optional<Customer> customer = customerService.findByCustomerId(customerId);
        Customer findCustomer = customer.get();
        //TODO handle error

        Account account = accountRepository.findByCustomer(findCustomer);
        return account.getBalance();
    }

    @Override
    public void updateAccount(Account account) {
        accountRepository.save(account);
    }

    @Override
    public List<Transaction> showTransactions(Long customerId) {
        Optional<Customer> customer = customerService.findByCustomerId(customerId);
        Customer findCustomer = customer.get();
        Account account = accountRepository.findByCustomer(findCustomer);
        //TODO handle error

        return account.getTransactionList();
    }

    public String setCurrentDate(){
        LocalDateTime dt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-YYYY H:m:s");
        String date = dt.format(dtf);
        return date;
    }
    public String setRandomAccountNo(){
        Long seed = System.currentTimeMillis();
        Random random = new Random(seed);
        Long number = Math.abs(random.nextLong() % 10000000000L);
        return number.toString();
    }

}
