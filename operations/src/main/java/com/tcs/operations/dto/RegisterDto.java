package com.tcs.operations.dto;

import com.tcs.operations.enums.Gender;
import lombok.Data;


@Data
public class RegisterDto {

    private String person_name;

    private Gender gender;

    private String identification;

    private String address;

    private String phone;
//properties of client
    private String password;

    private Boolean status;

}
