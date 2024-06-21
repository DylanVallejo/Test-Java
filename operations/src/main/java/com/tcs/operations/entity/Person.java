package com.tcs.operations.entity;


import com.tcs.operations.enums.Gender;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long person_id;

    private String person_name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private int age;

    private String identification;

    private String address;

    private String phone;

}
