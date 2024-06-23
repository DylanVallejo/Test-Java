package com.tcs.operations.dto;


import com.tcs.operations.enums.Transaction;
import lombok.Data;


@Data
public class MovementDto {

//    private Date movement_date;

    private Transaction movement_type;

    private Double amount;

    private Double balance;

//    private Long account_id;

}
