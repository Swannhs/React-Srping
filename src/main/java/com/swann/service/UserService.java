package com.swann.service;

import com.swann.entity.User;
import com.swann.exceaption.UserException;
import com.swann.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo repo;

    public User saveOrUpdate(User user) {
        try {
            return repo.save(user);
        } catch (Exception e) {
            throw new UserException("username (" + user.getName().toUpperCase() + ") is already taken");
        }
    }

    public Iterable<User> findAll() {
        return repo.findAll();
    }

//    public void delete(String name){
//        User user = repo.findByName(name);
//        if (user == null){{
//            throw new
//        }}
//    }
}
