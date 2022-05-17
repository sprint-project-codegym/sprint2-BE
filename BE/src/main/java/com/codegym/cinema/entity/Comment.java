package com.codegym.cinema.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Integer commentId;

    @Column(name = "content",columnDefinition = "varchar(50)")
    private String content;

    @Column(name = "img", columnDefinition = "LONGTEXT")
    private String img;

    @Column(name = "date", columnDefinition = "DATETIME")
    private String date;

    @Column(name = "rating", columnDefinition = "INT")
    private Integer rating;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "movie_id")
    private Movie movie;
}