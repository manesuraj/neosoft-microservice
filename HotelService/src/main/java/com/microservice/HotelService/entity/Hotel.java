package com.microservice.HotelService.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Hotel {

    @Id
    @Column(name ="Hotel_Id")
    private long hotelId;

    @Column(name = "Hotel_Name")
    private String hotelName;

    @Column(name = "Hotel_Location")
    private String location;

    @Column(name = "About_Hotel")
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
