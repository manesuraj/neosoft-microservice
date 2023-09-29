package com.microservice.UserService.exception;

public class UserNotFoundException extends RuntimeException{

    private long userId;
    private String message;

    public UserNotFoundException(){
        super("User Not Found With The Given User Id");
    }

    public UserNotFoundException(long userId, String message){
        this.userId=userId;
        this.message=message+" : "+userId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
