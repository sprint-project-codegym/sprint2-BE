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
import org.springframework.data.repository.query.Param;



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

    @Transactional
    @Modifying
    @Query(value = "update movie set movie_name = ?1, poster_movie = ?2, start_date = ?3, end_date = ?4, " +
            "movie_studio = ?5, actor = ?6, director = ?7, movie_length = ?8, trailer = ?9 where movie_id = ?10", nativeQuery = true)
    void editMovie(String movieName, String posterMovie, String startDate, String endDate, String studio,
                   String actor, String director, String length, String trailer, Integer movieId);

    @Query(value = "select m.movie_id, m.poster_movie, m.movie_name,m.start_date, m.end_date, m.movie_studio, m.actor, m.director,m.movie_length,m.movie_type,m.trailer,m.banner, m.promote, m.description, m.movie_status_id, m.delete_flag from movie as m where m.movie_id = :id and m.delete_flag = 1", nativeQuery = true)
    Movie findById(@Param("id") String id);

    @Query(value = "select m.movie_id, m.poster_movie, m.movie_name,m.start_date, m.end_date, m.movie_studio, m.actor, m.director,m.movie_length,m.movie_type,m.trailer,m.banner, m.promote, m.description, m.movie_status_id, m.delete_flag from movie as m where m.delete_flag = 1", nativeQuery = true)
    Page<Movie> findAll(Pageable page);

    @Query(value = "select m.movie_id, m.poster_movie, m.movie_name,m.start_date, m.end_date, m.movie_studio, m.actor, m.director,m.movie_length,m.movie_type,m.trailer,m.banner, m.promote, m.description, m.movie_status_id, m.delete_flag from movie as m where m.movie_name like %?1% and m.movie_studio like %?2% and delete_flag = 1 order by start_date",
            countQuery = "select count(*) from movie as m  where m.movie_name like %?1% and m.movie_studio like %?2% and delete_flag = 1", nativeQuery = true)
    Page<Movie> findByNameAndStudio(String name, String studio, Pageable page);

    @Modifying
    @Transactional
    @Query(value = "update movie set movie.delete_flag = 0 where movie.movie_id = :id", nativeQuery = true)
    void deleteByMovieId(@Param("id") String id);

    /**
     * Author : NhungHTC
     * function to get all movie have been add
     */
    @Query(value = "select * from movie", nativeQuery = true)
    List<Movie> getAllMovie();

    /**
     * Author: KhoaTM
     */
    @Query(value = "SELECT * FROM movie " +
            "WHERE start_date <= now() " +
            "AND end_date >= now() " +
            "ORDER BY start_date DESC", nativeQuery = true)
    Page<Movie> findOnShowingMovies(Pageable pageable);

    /**
     * Author: KhoaTM
     */
    @Query(value = "SELECT * FROM movie " +
            "WHERE start_date > now() " +
            "ORDER BY start_date", nativeQuery = true)
    Page<Movie> findUpComingMovies(Pageable pageable);

    /**
     * Author: KhoaTM
     */
    @Query(value = "SELECT m.*, SUM(mt.ticket_price) AS sales " +
            "FROM movie m " +
            "INNER JOIN movie_ticket mt ON m.movie_id = mt.movie_id " +
            "INNER JOIN ticket t ON mt.movie_ticket_id = t.movie_ticket_id " +
            "WHERE t.ticket_status = '2' " +
            "AND m.start_date <= now() " +
            "AND m.end_date >= now() " +
            "GROUP BY m.movie_id " +
            "ORDER BY sales DESC " +
            "LIMIT 3", nativeQuery = true)
    List<Movie> findTop3BySales();

    /**
     * Author: KhoaTM
     */
    @Query(value = "SELECT * " +
            "FROM movie " +
            "WHERE promote = 1 " +
            "AND end_date >= now()", nativeQuery = true)
    List<Movie> findPromotingMovies();

    /**
     * Author: KhoaTM
     */
    @Query(value = "SELECT * " +
            "FROM movie " +
            "WHERE end_date >= now() " +
            "AND movie_name LIKE CONCAT('%', ?1, '%') " +
            "ORDER BY movie_name", nativeQuery = true)
    Page<Movie> findByTitleContaining(String keySearch, Pageable pageable);

    /**
     * Author: KhoaTM
     */
    @Query(value = "SELECT * FROM movie m " +
            "INNER JOIN movie_category mc ON m.movie_id = mc.movie_id " +
            "INNER JOIN movie_ticket mt ON m.movie_id = mt.movie_id " +
            "WHERE m.end_date >= now() " +
            "AND m.movie_name LIKE CONCAT('%', ?1, '%') " +
            "AND mc.category_id LIKE ?2 " +
            "AND mt.show_date LIKE ?3 " +
            "AND mt.show_time_id LIKE ?4 " +
            "GROUP BY m.movie_id " +
            "ORDER BY m.movie_name", nativeQuery = true)
    Page<Movie> findByTitleAndCategoryAndDateAndShowTime(String keySearch, String categoryIdSearch,
                                                         String dateSearch, String showTimeIdSearch, Pageable pageable);


    /**
     * Author: DongVTH
     */
    @Query(value = "select *, ct.category_name from movie as mv \n" +
            "inner join movie_category as mc on mv.movie_id = mc.movie_id \n" +
            "inner join category as ct on ct.category_id = mc.category_id\n" +
            "where mv.movie_id = ?1", nativeQuery = true)
    Movie findMovieByMovieId(Integer id);

}
