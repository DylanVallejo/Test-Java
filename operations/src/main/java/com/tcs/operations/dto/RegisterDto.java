package com.tcs.operations.dto;

import com.tcs.operations.enums.Gender;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;


@Data
public class RegisterDto {

    private Long person_id;

    private String person_name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private int age;

    private String identification;

    private String address;

    private String phone;
//properties of client
    private Long client_id;

    private String password;

    private Boolean status;

//    private Long person_id;

}
