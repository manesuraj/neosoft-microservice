package com.microservice.RatingService.service.serviceImpl;

import com.microservice.RatingService.entity.Rating;
import com.microservice.RatingService.exception.RatingNotFoundException;
import com.microservice.RatingService.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements com.microservice.RatingService.service.RatingService {

    @Autowired
    private RatingRepository repository;

    @Override
    public Rating addRating(Rating rating) {
        repository.save(rating);
        return rating;
    }

    @Override
    public Rating returnSpecRating(long id) {
        return repository.findById(id).orElseThrow(()->new RatingNotFoundException(id, "Rating Not Found With This Hotel Id"));
    }

    @Override
    public List<Rating> getAllRating() {
        return repository.findAll();
    }

    @Override
    public Rating deleteRating(long id) {
        Rating rating = repository.findById(id).get();
        repository.delete(rating);
        return rating;
    }

    @Override
    public List<Rating> getRatingByUserId(long id){
        List<Rating> list = repository.findByUserId(id);
        return list;
    }
}
