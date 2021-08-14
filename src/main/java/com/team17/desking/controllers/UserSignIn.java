package com.team17.desking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team17.desking.entity.User;
import com.team17.desking.repository.UserRepository;

@RestController
public class UserSignIn {

    @Autowired
    private UserRepository repository;


    @PostMapping("/desking/signin/{email}")
    public boolean Authenticate(@PathVariable("email") String email) {

        User u = repository.findByEmail(email);
        if(u != null)
            return true;
        return false;
    }
}