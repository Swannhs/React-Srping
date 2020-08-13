package com.swann.exceaption;

public class UserIdExceptionResponse {

    private String userIdentifier;

    public UserIdExceptionResponse(String projectIdentifier) {
        this.userIdentifier = projectIdentifier;
    }

    public String getUserIdentifier() {
        return userIdentifier;
    }

    public void setProjectIdentifier(String projectIdentifier) {
        this.userIdentifier = projectIdentifier;
    }
}
