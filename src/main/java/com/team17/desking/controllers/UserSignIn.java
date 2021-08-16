package com.team17.desking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.team17.desking.entity.User;
import com.team17.desking.repository.UserRepository;

@RestController
public class UserSignIn {

    @Autowired
    private UserRepository repository;


    @CrossOrigin()
    @PostMapping("/desking/signin")
    public User Authenticate(@RequestBody User user) {

        User u = repository.findByEmail(user.getEmail());
        if(u != null)
            return u;
        return null;
    }
}
