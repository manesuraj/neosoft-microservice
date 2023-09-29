package com.microservice.HotelService.service;

import com.microservice.HotelService.entity.Hotel;

import java.util.List;

public interface HotelService {

    public Hotel addNewHotel(Hotel hotel);

    public Hotel getHotelById(long id);

    public List<Hotel> getAllHotel();

    public Hotel deleteHotel(long id);
}
