package com.microservice.RatingService.service;

import com.microservice.RatingService.entity.Rating;

import java.util.List;

public interface RatingService {

    public Rating addRating(Rating rating);

    public Rating returnSpecRating(long id);

    public List<Rating> getAllRating();

    public Rating deleteRating(long id);

    public List<Rating> getRatingByUserId(long id);
}
