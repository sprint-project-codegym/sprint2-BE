package com.codegym.cinema.repository;

import com.codegym.cinema.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

    @Query(value = "select m.movie_id, m.poster_movie, m.movie_name,m.start_date, m.end_date, m.movie_studio, m.actor, m.director,m.movie_length,m.movie_type,m.trailer,m.banner, m.promote, m.description, m.movie_status, m.delete_flag from movie as m where m.movie_id = :id and m.delete_flag = 1", nativeQuery = true)
    Movie findById(@Param("id") String id);

    @Query(value = "select m.movie_id, m.poster_movie, m.movie_name,m.start_date, m.end_date, m.movie_studio, m.actor, m.director,m.movie_length,m.movie_type,m.trailer,m.banner, m.promote, m.description, m.movie_status, m.delete_flag from movie as m where m.delete_flag = 1", nativeQuery = true)
    Page<Movie> findAll(Pageable page);

    @Query(value = "select m.movie_id, m.poster_movie, m.movie_name,m.start_date, m.end_date, m.movie_studio, m.actor, m.director,m.movie_length,m.movie_type,m.trailer,m.banner, m.promote, m.description, m.movie_status, m.delete_flag from movie as m where m.movie_name like %?1% and m.movie_studio like %?2% and delete_flag = 1 order by start_date",
            countQuery = "select count(*) from movie as m  where m.movie_name like %?1% and m.movie_studio like %?2% and delete_flag = 1", nativeQuery = true)
    Page<Movie> findByNameAndStudio(String name, String studio, Pageable page);

    @Modifying
    @Transactional
    @Query(value = "update movie set movie.delete_flag = 0 where movie.movie_id = :id", nativeQuery = true)
    void deleteByMovieId(@Param("id") String id);


}
