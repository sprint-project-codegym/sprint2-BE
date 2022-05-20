package com.codegym.cinema.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "transaction_history")
public class TransactionHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Integer transactionId;

    @Column(name = "transaction_date", columnDefinition = "date")
    private String transactionDate;

    @ManyToOne
    @JoinColumn(name = "username", columnDefinition = "varchar(50)")
    private Account account;

    @Column(name = "description", columnDefinition = "varchar(2000)")
    private String description;

    @Column(name = "status", columnDefinition = "bit(1)")
    private boolean status;
}
