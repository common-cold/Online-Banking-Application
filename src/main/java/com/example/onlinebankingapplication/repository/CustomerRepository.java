package com.example.onlinebankingapplication.repository;

import com.example.onlinebankingapplication.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
