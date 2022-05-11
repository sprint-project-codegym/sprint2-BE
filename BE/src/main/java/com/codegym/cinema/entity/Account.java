package com.codegym.cinema.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    @Column(name = "account_status", columnDefinition = "BIT(1)")
    private boolean accountStatus;

    @OneToOne(mappedBy = "account")
    @JsonBackReference
    private User user;

    @Column(name = "point", columnDefinition = "varchar(50)")
    private String point;

    @Column(name = "verification_code", columnDefinition = "varchar(100)")
    private String verificationCode;

    @Column(name = "is_enable", columnDefinition = "bit(1)")
    private Boolean isEnable;

    @Column(name = "provider", columnDefinition = "VARCHAR(20)")
    private String provider;

    @OneToMany(mappedBy = "account")
    @JsonIgnore
    private Set<TransactionHistory> transactionHistorySet;

    @OneToMany(mappedBy = "account")
    @JsonBackReference
    private Set<AccountRole> roles;

    @Override
    public String toString() {
        return null;
    }
}
