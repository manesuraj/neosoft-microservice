package com.microservice.UserService.controller;

import com.microservice.UserService.entity.CustomeResponse;
import com.microservice.UserService.entity.User;
import com.microservice.UserService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/microservice/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/addNewUser")
    public ResponseEntity<?> addNewUser(@RequestBody User user){
        try{
            User newUser = service.addNewUser(user);
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        }catch(Exception e){
            CustomeResponse response = new CustomeResponse();
            response.setStatusCode(500);
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<?> getSpecificUser(@PathVariable long id){
        try{
            User user = service.getUserById(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }catch(Exception e){
            CustomeResponse response = new CustomeResponse();
            response.setStatusCode(500);
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllUser")
    public ResponseEntity<?> getAllUser(){
        try{
            List<User> users = service.getAllUser();
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
