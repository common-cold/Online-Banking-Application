package com.example.onlinebankingapplication.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountId;
    private String accountNo;
    private String createDate ;
    private Long balance;
    private boolean isActive = true;

    @OneToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "customerId",
            referencedColumnName = "customerId"
    )
    private Customer customer;

    @OneToMany(
            mappedBy = "account",
            fetch = FetchType.LAZY
    )
    public List<Transaction> transactionList;
}
