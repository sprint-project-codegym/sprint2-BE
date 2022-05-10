package com.codegym.cinema.repository;

import com.codegym.cinema.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    @Transactional
    @Modifying
    @Query(value = "insert into movie(actor, banner, description, director, start_date, end_date, movie_length, movie_name, movie_studio," +
            "poster_movie, trailer, delete_flag) values (?1, ?2, ?3, ?4, DATE ?5, DATE ?6, ?7, ?8, ?9, ?10, ?11, ?12);", nativeQuery = true)
    void createMovie(String actor, String banner, String description, String director, String startDate, String endDate, int movieLength,
                     String movieName, String movieStudio, String posterMovie, String trailer, int deleteFlag);

    @Query(value = "select movie_id from movie where actor = ?1 and banner = ?2 and description = ?3 and director= ?4 and start_date= ?5 and end_date= ?6 and movie_length= ?7 and movie_name= ?8 and movie_studio= ?9 and poster_movie = ?10 and trailer = ?11 and delete_flag = 1", nativeQuery = true)
    List<Integer> search(String actor, String banner, String description, String director, String startDate, String endDate, int movieLength, String movieName, String movieStudio, String poster, String trailer, Integer deleteFlag);
    @Query(value = "update movie SET actor = ?1 , banner = ?2 , description = ?3 , director= ?4 , start_date= ?5 , end_date= ?6 , movie_length= ?7 , movie_name= ?8 , movie_studio= ?9 , poster_movie = ?10 , trailer = ?11 where movie_id = ?1", nativeQuery = true)
    void saveMovie(Integer id, String actor, String banner, String description, String director, String startDate, String endDate, int movieLength, String movieName, String movieStudio, String poster, String trailer);

//    @Query(value = "select movie.movie_id from movie where actor = ?1 and banner = ?2 and description = ?3 and director = ?4 and start_date = ?5 and end_date = ?6 and movie_length = ?7 " +
//            "and movie_name = ?8 and movie_studio = ?9 and poster_movie = ?10 and trailer = ?11 and delete_flag = 1")
//    int getMovieId(String actor, String banner, String description, String director, String startDate, String endDate, int movieLength,
//                            String movieName, String movieStudio, String posterMovie, String trailer, int deleteFlag);

}
