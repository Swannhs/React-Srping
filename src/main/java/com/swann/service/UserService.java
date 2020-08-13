package com.swann.service;

import com.swann.entity.UserPost;
import com.swann.exceaption.UserIdException;
import com.swann.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserPost saveOrUpdateProject(UserPost user){
        try{
            return userRepository.save(user);
        }catch (Exception e){
            throw new UserIdException("Project ID '"+user.getId()+"' already exists");
        }

    }


    public UserPost findProjectByIdentifier(String userId){

        UserPost post = userRepository.findByUserIdentifier(userId);
        System.out.println(userId);
        System.out.println(post);
        if(post == null){
            throw new UserIdException("User ID '"+userId+"' does not exist");

        }
        return post;
    }
//
    public Iterable<UserPost> findAllProjects(){
        return userRepository.findAll();
    }
//
//
//    public void deleteProjectByIdentifier(String userId){
//        User project = userRepository.findByUserId(userId);
//
//        if(project == null){
//            throw  new UserIdException("Cannot Project with ID '"+userId+"'. This project does not exist");
//        }
//
//        userRepository.delete(project);
//    }

}
