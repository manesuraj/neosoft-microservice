package com.microservice.UserService.service.serviceImpl;

import com.microservice.UserService.entity.User;
import com.microservice.UserService.exception.UserNotFoundException;
import com.microservice.UserService.repository.UserRepository;
import com.microservice.UserService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User addNewUser(User user) {
        return repository.save(user);
    }

    @Override
    public User getUserById(long id) {
        User user =  repository.findById(id).orElseThrow(()->new UserNotFoundException(id, "User Not Found With This User Id "));
 //       user.set
        return user;
    }

    @Override
    public List<User> getAllUser() {
        return repository.findAll();
    }
}
