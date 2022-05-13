package com.codegym.cinema.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "`role`",
        uniqueConstraints = {
                @UniqueConstraint(name = "ROLE_UK", columnNames = "role_id")
        })
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "role_name", columnDefinition = "VARCHAR(50)")
    private String roleName;
}
