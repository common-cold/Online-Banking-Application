package com.example.onlinebankingapplication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long addressId;
    private String addressLine1;
    private String postalCode;
    private String city;
    private String state;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "customerId",
            referencedColumnName = "customerId"
    )
    private Customer customer;
}
