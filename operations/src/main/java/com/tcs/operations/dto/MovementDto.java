package com.tcs.operations.dto;


import com.tcs.operations.enums.Transaction;
import lombok.Data;

import java.sql.Date;

@Data
public class MovementDto {

    private Date movement_date;

    private Transaction movement_type;

    private double amount;

    private double balance;

//    private Long account_id;

}
