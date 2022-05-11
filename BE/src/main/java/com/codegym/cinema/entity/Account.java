package com.codegym.cinema.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "account",
        uniqueConstraints = {
                @UniqueConstraint(name = "ACC_UK", columnNames = "username")
        })
public class Account {
    @Id
    @Column(name = "username", columnDefinition = "VARCHAR(50) UNIQUE NOT NULL")
    private String username;

    @Column(name = "`password`", columnDefinition = "VARCHAR(255)")
    private String password;

    @Column(name = "register_date", columnDefinition = "DATE")
    private String registerDate;

    @Column(name = "account_status", columnDefinition = "VARCHAR(50)")
    private String accountStatus;

    @OneToOne(mappedBy = "account")
    @JsonIgnore
    private User user;

    @Column(name = "point", columnDefinition = "varchar(50)")
    private String point;

    @OneToMany(mappedBy = "account")
    @JsonIgnore
    private Set<TransactionHistory> transactionHistorySet;
}
