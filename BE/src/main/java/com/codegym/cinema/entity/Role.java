package com.codegym.cinema.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "`role`",
        uniqueConstraints = {
                @UniqueConstraint(name = "ROLE_UK", columnNames = "role_id")
        })
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "role_name", columnDefinition = "VARCHAR(50)")
    private String roleName;
}
