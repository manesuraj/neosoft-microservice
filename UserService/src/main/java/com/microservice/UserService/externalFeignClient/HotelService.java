package com.microservice.UserService.externalFeignClient;

import com.microservice.UserService.entity.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {

    @GetMapping("/microservice/hotel/getHotel/{id}")
    public Hotel getSpecificHotel(@PathVariable long id);

}
