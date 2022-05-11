package com.codegym.cinema.repository;
import com.codegym.cinema.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    /**
     * Author : NhungHTC
     * function to get all movie have been add
     */
    @Query(value = "select * from movie", nativeQuery = true)
    List<Movie> getAllMovie();
}
