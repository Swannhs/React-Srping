package com.swann.controller;

import com.swann.entity.User;
import com.swann.service.UserService;
import com.swann.repository.MapValidationError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/login")
public class HomeController {
    @Autowired
    private UserService service;

    @Autowired
    private MapValidationError mapValidationError;


    @PostMapping
    public ResponseEntity<?> createNewUser(@Valid @RequestBody User user, BindingResult result) {
        ResponseEntity<?> errorMap = mapValidationError.MapValidationError(result);
        if (errorMap != null) {
            return errorMap;
        }
        service.saveOrUpdate(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping
    public Iterable<User> getAllUser() {
        return service.findAll();
    }
}
