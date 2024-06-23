package com.tcs.operations.entity;


import com.tcs.operations.enums.AccountType;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Account {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long account_id;

    private String account_number;

    @Enumerated(EnumType.STRING)
    private AccountType account_type;

    private Double initial_balance;

    private Boolean account_status;

    private Long client_id;


}
