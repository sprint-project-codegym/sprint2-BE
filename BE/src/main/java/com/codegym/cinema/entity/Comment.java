package com.codegym.cinema.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
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

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "movie_id")
    private Movie movie;


//    @ManyToOne
//    @JoinColumn(name = "comment_parent_id",referencedColumnName = "comment_id")
//    private Comment comment;




}
