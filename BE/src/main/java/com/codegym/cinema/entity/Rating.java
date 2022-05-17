package com.codegym.cinema.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "rating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "rating_id")
    private Integer ratingId;

    @Column(name = "rating", columnDefinition = "int")
    private Integer rating;

    @Column(name = "comment", columnDefinition = "varchar(255)")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "movie_id")
    private Movie movie;
}
