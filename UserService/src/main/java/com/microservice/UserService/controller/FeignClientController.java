package com.microservice.UserService.controller;

import com.microservice.UserService.entity.CustomeResponse;
import com.microservice.UserService.entity.Hotel;
import com.microservice.UserService.entity.Rating;
import com.microservice.UserService.entity.User;
import com.microservice.UserService.service.FeignClientService;
import com.netflix.discovery.converters.Auto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/microservice/user/feignClient")
public class FeignClientController {

    private Logger LOGGER = LoggerFactory.getLogger(FeignClientController.class);

    @Autowired
    private FeignClientService service;

    @GetMapping("/getHotel/{hotelId}")
    public ResponseEntity<?> getHotelById(@PathVariable long hotelId){
        try{
            Hotel hotel = service.getHotelById(hotelId);
            return new ResponseEntity<>(hotel, HttpStatus.OK);
        }catch(Exception e){
            CustomeResponse response = new CustomeResponse();
            response.setStatusCode(500);
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getRating/{userId}")
    public ResponseEntity<?> getRatingById(@PathVariable long userId){
        try{
            List<Rating> ratings = service.getAllRating(userId);
            return new ResponseEntity<>(ratings, HttpStatus.OK);
        }catch(Exception e){
            CustomeResponse response = new CustomeResponse();
            response.setStatusCode(500);
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getUser/{userId}")
    @CircuitBreaker(name = "hotelRatingBreaker", fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<?> getUserWithRatingAndHotel(@PathVariable long userId){
        try{
            User user = service.getUserWithRatingAndHotel(userId);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }catch(Exception e){
            CustomeResponse response = new CustomeResponse();
            response.setStatusCode(500);
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/getAllUsers")
    public ResponseEntity<?> getAllUserWithRatingAndHotel(){
        try{
            List<User> users = service.getAllUserWithRatingAndHotel();
            return new ResponseEntity<>(users, HttpStatus.OK);
        }catch(Exception e){
            CustomeResponse response = new CustomeResponse();
            response.setStatusCode(500);
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
