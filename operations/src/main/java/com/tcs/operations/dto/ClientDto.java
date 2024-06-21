package com.tcs.operations.dto;


import lombok.Data;

@Data
public class ClientDto {

    private Long client_id;

    private String address;

    private String phone;

    private String password;

    private Boolean status;

}
