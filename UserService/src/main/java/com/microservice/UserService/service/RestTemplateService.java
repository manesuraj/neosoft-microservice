package com.microservice.UserService.service;

import com.microservice.UserService.entity.User;

import java.util.List;

public interface RestTemplateService {

    public User getUserWithRating(long userId);

    public List<User> getAllUsersWithRating();

    public List<User> getAllUserWithRatingAndHotel();

}
