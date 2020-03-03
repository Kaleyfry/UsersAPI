package com.tts.UsersAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tts.UsersAPI.model.User;
import com.tts.UsersAPI.repository.Repository;

@RestController
public class controller {
	
	@Autowired
	private Repository repository;
	
	@GetMapping("/users")
    public List<User> getUsers(){
        return (List<User>) repository.findAll();
    }

}
