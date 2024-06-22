package com.tcs.operations.dto;


import com.tcs.operations.enums.AccountType;
import lombok.Data;

@Data
public class AccountDto {

    private String account_number;

    private AccountType account_type;

    private Double initial_balance;

    private Boolean account_status;

//    private Long client_id;

}
