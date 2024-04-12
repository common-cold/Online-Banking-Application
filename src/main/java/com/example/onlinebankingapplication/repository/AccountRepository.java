package com.example.onlinebankingapplication.repository;

import com.example.onlinebankingapplication.entity.Account;
import com.example.onlinebankingapplication.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    public Account findByCustomer(Customer customer);
}
