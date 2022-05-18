package com.codegym.cinema.repository;

import com.codegym.cinema.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface RatingRepository extends JpaRepository<Rating, Integer> {
    @Modifying
    @Query(value = "INSERT INTO `a0321i1_cinema`.`rating` (:#{#rating.ratingId}, :#{#rating.rating}, :#{#rating.comment},:#{#rating.movie}, " + ":#{#rating.user})", nativeQuery = true)
    @Transactional
    void saveRating(Rating rating);
}
