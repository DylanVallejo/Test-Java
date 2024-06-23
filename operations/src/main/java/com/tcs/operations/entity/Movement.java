package com.tcs.operations.entity;

import com.tcs.operations.enums.Transaction;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;


@Entity
@Data
public class Movement {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long movement_id;

    private LocalDateTime movement_date;

    @Enumerated(EnumType.STRING)
    private Transaction movement_type;

    private Double amount;

    private Double balance;

    private Long account_id;

}
