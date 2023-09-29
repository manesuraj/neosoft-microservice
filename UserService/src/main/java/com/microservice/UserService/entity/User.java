package com.microservice.UserService.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @Column(name = "User_Id")
    private long userId;

    @Column(name = "User_Name")
    private String name;

    @Column(name = "User_Email")
    private String email;

    @Column(name = "About_User")
    private String about;

    @Transient
    private List<Rating> rating = new ArrayList<Rating>();

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public User() {
    }

    public User(long userId, String name, String email, String about, List<Rating> rating) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.about = about;
        this.rating = rating;
    }

    public List<Rating> getRating() {
        return rating;
    }

    public void setRating(List<Rating> rating) {
        this.rating = rating;
    }
}
