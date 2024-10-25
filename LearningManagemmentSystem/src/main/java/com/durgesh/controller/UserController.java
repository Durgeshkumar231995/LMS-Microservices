package com.durgesh.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.durgesh.model.User;
import com.durgesh.service.UserServiceImpl;

//@RestController
@RequestMapping("/api/v1.0/user")
public class UserController {
	
	@Autowired
	private UserServiceImpl  userService;
	
	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@Valid @RequestBody User user){
		
		
		User saveUser = userService.saveUser(user);
		
		return new ResponseEntity<>(saveUser,HttpStatus.CREATED);
		
	}

}
