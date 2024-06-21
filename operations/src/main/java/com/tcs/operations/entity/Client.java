package com.tcs.operations.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Client extends Person {

//    @Id
//    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long client_id;

    private String password;

    private Boolean status;

//    private Long person_id;

//    @OneToOne
//    private Person person;
//
//    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
//    private List<Account> account;

}
