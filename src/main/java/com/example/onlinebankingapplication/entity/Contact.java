package com.example.onlinebankingapplication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long contactId;
    private String contactNo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "customerId",
            referencedColumnName = "customerId"
    )
    private Customer customer;
}
