package com.microservice.RatingService.repository;

import com.microservice.RatingService.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Long> {

    public List<Rating> findByUserId(long id);
}
