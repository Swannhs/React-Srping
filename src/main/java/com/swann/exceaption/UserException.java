package com.swann.exceaption;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserException extends RuntimeException {
    public UserException(String message) {
        super(message);
    }
}
