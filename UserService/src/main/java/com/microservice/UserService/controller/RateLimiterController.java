package com.microservice.UserService.controller;

import com.microservice.UserService.entity.User;
import com.microservice.UserService.service.FeignClientService;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/microservice/user/rateLimiter")
public class RateLimiterController {

    private Logger LOGGER = LoggerFactory.getLogger(CircuitBreakerController.class);

    @Autowired
    private FeignClientService service;

    @GetMapping("/getUser/{userId}")
    @RateLimiter(name = "userHotelRatingLimiter", fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<?> getUserWithRatingAndHotel(@PathVariable long userId){
        User user = service.getUserWithRatingAndHotel(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    public ResponseEntity<?> ratingHotelFallback(long userId, Exception ex){
        LOGGER.info("Fallback is executed because one service is down : "+ ex.getMessage());
        User user = new User();
        user.setUserId(1111);
        user.setName("Dummy");
        user.setEmail("dummy123@gmail.com");
        user.setAbout("Return the dummy object because one of the service is down");
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


}
