package com.tcs.operations.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Client extends Person {

    private Long client_id;

    private String password;

    private Boolean status;

}
