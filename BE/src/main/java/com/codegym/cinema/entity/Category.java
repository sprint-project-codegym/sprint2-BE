package com.codegym.cinema.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "category",
        uniqueConstraints = {
                @UniqueConstraint(name = "CATEGORY_UK", columnNames = "category_id")
        })
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "category_name")
    private String categoryName;

}
