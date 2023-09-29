package com.microservice.UserService.controller;

import com.microservice.UserService.entity.CustomeResponse;
import com.microservice.UserService.entity.User;
import com.microservice.UserService.service.RestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/microservices/restTemplate")
public class RestTemplateController {

    @Autowired
    private RestTemplateService service;

    @GetMapping("/getUserWithRating/{userId}")
    public ResponseEntity<?> getUserAndCorrespondingReting(@PathVariable long userId){
        try{
            User user = service.getUserWithRating(userId);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }catch(Exception e){
            CustomeResponse response = new CustomeResponse();
            response.setStatusCode(500);
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllUsersWithRating")
    public ResponseEntity<?> getAllUsersWithRating(){
        try{
            List<User> users = service.getAllUsersWithRating();
            return new ResponseEntity<>(users, HttpStatus.OK);
        }catch(Exception e){
            CustomeResponse response = new CustomeResponse();
            response.setStatusCode(500);
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllUserWithRatingAndHotel")
    public ResponseEntity<?> getAllUsersWithRatingAndHotel(){
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
