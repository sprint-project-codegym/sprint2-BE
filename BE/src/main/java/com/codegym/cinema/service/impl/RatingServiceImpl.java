package com.codegym.cinema.service.impl;

import com.codegym.cinema.entity.Rating;
import com.codegym.cinema.repository.RatingRepository;
import com.codegym.cinema.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    private RatingRepository ratingRepository;

    /**
     * Author: DongVTH
     */
    @Override
    public void saveRating(Rating rating) {
        Rating rating1 = new Rating();
        rating1.setRatingId(rating.getRatingId());
        rating1.setRating(rating.getRating());
        rating1.setComment(rating.getComment());
        rating1.setMovie(rating.getMovie());
        rating1.setUser(rating.getUser());
        ratingRepository.saveRating(rating1);
    }
}
