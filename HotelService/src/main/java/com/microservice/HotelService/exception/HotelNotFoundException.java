package com.microservice.HotelService.exception;

public class HotelNotFoundException extends RuntimeException{

    private long id;
    private String message;
    public HotelNotFoundException(){
        super("Hotel Not Found With Given Hotel Id");
    }

    public HotelNotFoundException(long id, String message){
        this.id=id;
        this.message=message+" : "+id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
