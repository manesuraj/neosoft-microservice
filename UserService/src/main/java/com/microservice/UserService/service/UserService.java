package com.microservice.UserService.service;

import com.microservice.UserService.entity.User;

import java.util.List;

public interface UserService {

    public User addNewUser(User user);

    public User getUserById(long id);

    public List<User> getAllUser();
}
