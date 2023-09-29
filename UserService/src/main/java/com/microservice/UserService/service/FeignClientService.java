package com.microservice.UserService.service;

import com.microservice.UserService.entity.Hotel;
import com.microservice.UserService.entity.Rating;
import com.microservice.UserService.entity.User;

import java.util.List;

public interface FeignClientService {

    public Hotel getHotelById(long hotelId);


    public List<Rating> getAllRating(long userId);

    public User getUserWithRatingAndHotel(long userId);

    public List<User> getAllUserWithRatingAndHotel();
}
