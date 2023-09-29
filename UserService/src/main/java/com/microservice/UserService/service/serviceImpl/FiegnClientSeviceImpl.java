package com.microservice.UserService.service.serviceImpl;

import com.microservice.UserService.entity.Hotel;
import com.microservice.UserService.entity.Rating;
import com.microservice.UserService.entity.User;
import com.microservice.UserService.exception.UserNotFoundException;
import com.microservice.UserService.externalFeignClient.HotelService;
import com.microservice.UserService.externalFeignClient.RatingService;
import com.microservice.UserService.repository.UserRepository;
import com.microservice.UserService.service.FeignClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FiegnClientSeviceImpl implements FeignClientService {

    @Autowired
    private HotelService service;

    @Autowired
    private RatingService ratingService;

    @Autowired
    UserRepository repository;

    @Override
    public Hotel getHotelById(long hotelId) {
        Hotel hotel = service.getSpecificHotel(hotelId);
        return hotel;
    }

    @Override
    public List<Rating> getAllRating(long userId) {
        List<Rating> ratings = ratingService.getAllRatingByUserId(userId);
        return ratings;
    }

    @Override
    public User getUserWithRatingAndHotel(long userId) {
        User user = repository.findById(userId).orElseThrow(()-> new UserNotFoundException(userId, "User Not Found With Given Uer Id "));

        List<Rating> ratings = ratingService.getAllRatingByUserId(userId);
        for(Rating rating : ratings){
            Hotel hotel = service.getSpecificHotel(rating.getHotelId());
            rating.setHotel(hotel);
        }
        user.setRating(ratings);
        return user;
    }

    @Override
    public List<User> getAllUserWithRatingAndHotel() {
        List<User> users = repository.findAll();

        for(User user : users){
            List<Rating> ratings = ratingService.getAllRatingByUserId(user.getUserId());
            for(Rating rating : ratings){
                Hotel hotel = service.getSpecificHotel(rating.getHotelId());
                rating.setHotel(hotel);
            }
            user.setRating(ratings);
        }
        return users;
    }
}
