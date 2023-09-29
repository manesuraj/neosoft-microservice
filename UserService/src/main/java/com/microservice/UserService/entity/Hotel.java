package com.microservice.UserService.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class Hotel {

    private long hotelId;
    private String hotelName;
    private String location;
    private String about;


    public long getHotelId() {
        return hotelId;
    }

    public void setHotelId(long hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Hotel(long hotelId, String hotelName, String location, String about) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.location = location;
        this.about = about;
    }

    public Hotel() {
    }
}
