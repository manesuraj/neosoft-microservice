package com.microservice.RatingService.exception;

public class RatingNotFoundException extends RuntimeException{

    private long ratingId;
    private String message;

    public RatingNotFoundException(){
        super("Rating Not Found With This Rating Id");
    }

    public RatingNotFoundException(long id, String message){
        this.ratingId=id;
        this.message=message+" : "+id;
    }

    public long getRatingId() {
        return ratingId;
    }

    public void setRatingId(long ratingId) {
        this.ratingId = ratingId;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
