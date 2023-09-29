package com.microservice.UserService.externalFeignClient;

import com.microservice.UserService.entity.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

    @GetMapping("/microservice/rating/user/rating/{userId}")
    public List<Rating> getAllRatingByUserId(@PathVariable long userId);

}
