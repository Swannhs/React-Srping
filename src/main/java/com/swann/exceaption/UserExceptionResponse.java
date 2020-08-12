package com.swann.exceaption;

import lombok.Data;

@Data
public class UserExceptionResponse {
    private String name;

    public UserExceptionResponse(String name) {
        this.name = name;
    }
}
