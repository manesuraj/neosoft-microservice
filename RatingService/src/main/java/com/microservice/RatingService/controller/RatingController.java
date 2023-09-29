package com.microservice.RatingService.controller;

import com.microservice.RatingService.entity.CustomResponse;
import com.microservice.RatingService.entity.Rating;
import com.microservice.RatingService.service.RatingService;
import jakarta.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/microservice/rating")
public class RatingController {

    @Autowired
    private RatingService service;

    @GetMapping("/home")
    public String returnString(){
        return "Request is comming";
    }

    @PostMapping("/addRating")
    public ResponseEntity<?> addNewRating(@RequestBody Rating rating){
        try{
            Rating newRating = service.addRating(rating);
            return new ResponseEntity<>(newRating, HttpStatus.CREATED);
        }catch (Exception e){
            CustomResponse response = new CustomResponse();
            response.setStatusCode(500);
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getRating/{id}")
    public ResponseEntity<?> getRating(@PathVariable long id){
        try{
            Rating rating = service.returnSpecRating(id);
            return new ResponseEntity<>(rating, HttpStatus.OK);
        }catch (Exception e){
            CustomResponse response = new CustomResponse();
            response.setStatusCode(500);
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllRating")
    public ResponseEntity<?> getAllRating(){
        try{
            List<Rating> ratings = service.getAllRating();
            return new ResponseEntity<>(ratings, HttpStatus.OK);
        }catch (Exception e){
            CustomResponse response = new CustomResponse();
            response.setStatusCode(500);
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/user/rating/{userId}")
    public ResponseEntity<?> getRatingOfUser(@PathVariable long userId){
        try{
            List<Rating> ratings = service.getRatingByUserId(userId);
            return new ResponseEntity<>(ratings, HttpStatus.OK);
        }catch(Exception e){
            CustomResponse response = new CustomResponse();
            response.setStatusCode(500);
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
