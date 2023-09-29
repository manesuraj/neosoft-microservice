package com.microservice.HotelService.controller;

import com.microservice.HotelService.entity.CustomResponse;
import com.microservice.HotelService.entity.Hotel;
import com.microservice.HotelService.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/microservice/hotel")
public class HotelController {

    @Autowired
    private HotelService service;

    @PostMapping("/addNew")
    public ResponseEntity<?> addNewHotel(@RequestBody Hotel hotel){
        try{
            Hotel newHotel = service.addNewHotel(hotel);
            return new ResponseEntity<>(newHotel, HttpStatus.CREATED);
        }catch (Exception e){
            CustomResponse response = new CustomResponse();
            response.setStatusCode(500);
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getHotel/{id}")
    public ResponseEntity<?> getSpecificHotel(@PathVariable long id){
        try{
            Hotel hotel = service.getHotelById(id);
            return new ResponseEntity<>(hotel, HttpStatus.OK);
        }catch(Exception e){
            CustomResponse response = new CustomResponse();
            response.setStatusCode(500);
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllHotels")
    public ResponseEntity<?> getAllHotelList(){
        try{
            List<Hotel> hotels = service.getAllHotel();
            return new ResponseEntity<>(hotels, HttpStatus.OK);
        }catch(Exception e){
            CustomResponse response = new CustomResponse();
            response.setStatusCode(500);
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteHotel/{id}")
    public ResponseEntity<?> deleteHotelById(@PathVariable long id){
        try{
            Hotel hotel = service.deleteHotel(id);
            return new ResponseEntity<>(hotel, HttpStatus.OK);
        }catch (Exception e){
            CustomResponse response = new CustomResponse();
            response.setStatusCode(500);
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
