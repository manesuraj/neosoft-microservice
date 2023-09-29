package com.microservice.UserService.service.serviceImpl;

import com.microservice.UserService.entity.Hotel;
import com.microservice.UserService.entity.Rating;
import com.microservice.UserService.entity.User;
import com.microservice.UserService.exception.UserNotFoundException;
import com.microservice.UserService.repository.UserRepository;
import com.microservice.UserService.service.RestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class RestTemplateServiceImpl implements RestTemplateService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private RestTemplate template;

    @Override
    public User getUserWithRating(long userId) {
        User user = repository.findById(userId).orElseThrow(()-> new UserNotFoundException(userId, "User Not Found With Given User Id"));

        List<Rating> list = template.getForObject("http://RATING-SERVICE/microservice/rating/user/rating/"+userId, ArrayList.class);
        user.setRating(list);
        return user;
    }

    @Override
    public List<User> getAllUsersWithRating() {
        List<User> users = repository.findAll();

        for(User user : users){
            List<Rating> ratings = template.getForObject("http://RATING-SERVICE/microservice/rating/user/rating/"+user.getUserId(), ArrayList.class);
            user.setRating(ratings);
        }
        return users;
    }

    @Override
    public List<User> getAllUserWithRatingAndHotel() {
        List<User> users = repository.findAll();

        for(User user : users){
            Rating[] ratings = template.getForObject("http://RATING-SERVICE/microservice/rating/user/rating/"+user.getUserId(), Rating[].class
            );
            for(Rating rating : ratings){
//                Hotel hotel = template.getForObject("http://localhost:8082/microservice/hotel/getHotel/"+rating.getHotelId(), Hotel.class);
//                rating.setHotel(hotel);
                ResponseEntity<Hotel> response = template.getForEntity("http://HOTEL-SERVICE/microservice/hotel/getHotel/"+rating.getHotelId(), Hotel.class);
                Hotel hotel = response.getBody();
                rating.setHotel(hotel);
            }
            user.setRating(Arrays.stream(ratings).toList());
        }
        return users;
    }
}
