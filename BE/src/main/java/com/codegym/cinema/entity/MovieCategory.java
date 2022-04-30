package com.codegym.cinema.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "movie_category",
        uniqueConstraints = {
                @UniqueConstraint(name = "CATEGORY_UK", columnNames = {"category_id", "movie_id"})
        })
public class MovieCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_category_id")
    private Integer movieCategoryId;

    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "movie_id")
    @JsonBackReference
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    @JsonBackReference
    private Category category;
}
