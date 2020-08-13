package com.swann.controller;


import com.swann.entity.UserPost;
import com.swann.service.MapValidationErrorService;
import com.swann.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/post")
@CrossOrigin
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;


    @PostMapping("")
    public ResponseEntity<?> createNewPost(@Valid @RequestBody UserPost user, BindingResult result){

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap!=null) return errorMap;

        UserPost project1 = userService.saveOrUpdateProject(user);
        return new ResponseEntity<UserPost>(project1, HttpStatus.CREATED);
    }

//
    @GetMapping("/{userId}")
    public ResponseEntity<?> getProjectById(@PathVariable String userId){

        UserPost project = userService.findProjectByIdentifier(userId);

        return new ResponseEntity<UserPost>(project, HttpStatus.OK);
    }
//
//
    @GetMapping("/all")
    public Iterable<UserPost> getAllProjects(){return userService.findAllProjects();}
//
//
//    @DeleteMapping("/{userId}")
//    public ResponseEntity<?> deleteProject(@PathVariable String userId){
//        userService.deleteProjectByIdentifier(userId);
//
//        return new ResponseEntity<String>("Project with ID: '"+userId+"' was deleted", HttpStatus.OK);
//    }
}
