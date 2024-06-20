package com.tcs.operations.entity;

import com.tcs.operations.enums.Transaction;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.sql.Date;


@Entity
@Data
public class Movement {

    @Id
    private Long movement_id;

    private Date movement_date;

    private Transaction movement_type;

    private double amount;

    private double balance;

    private Long account_id;

    @ManyToOne
    private Account account;

}
