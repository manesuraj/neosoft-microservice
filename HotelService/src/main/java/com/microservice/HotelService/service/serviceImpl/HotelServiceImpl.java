package com.microservice.HotelService.service.serviceImpl;

import com.microservice.HotelService.entity.Hotel;
import com.microservice.HotelService.exception.HotelNotFoundException;
import com.microservice.HotelService.repository.HotelRepository;
import com.microservice.HotelService.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository repository;
    @Override
    public Hotel addNewHotel(Hotel hotel) {
        repository.save(hotel);
        return hotel;
    }

    @Override
    public Hotel getHotelById(long id) {
       return repository.findById(id).orElseThrow(()-> new  HotelNotFoundException(id, "Hotel Not Fouund With Given Id"));
    }

    @Override
    public List<Hotel> getAllHotel() {
        return repository.findAll();
    }

    @Override
    public Hotel deleteHotel(long id) {
        Hotel hotel = repository.findById(id).get();
        repository.delete(hotel);
        return hotel;
    }
}
