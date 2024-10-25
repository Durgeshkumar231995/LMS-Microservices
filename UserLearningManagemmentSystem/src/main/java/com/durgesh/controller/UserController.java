package com.durgesh.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.durgesh.jwt.JwtTokenUtil;
import com.durgesh.model.User;
import com.durgesh.request.AuthRequest;
import com.durgesh.request.AuthResponse;
import com.durgesh.service.IUserService;

@RestController
@RequestMapping("/api/v1.0/user")
@CrossOrigin("http://localhost:4200/")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	 @Autowired AuthenticationManager authManager;
	    @Autowired JwtTokenUtil jwtUtil;
	
	

	
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@Valid @RequestBody User user){
		
		 user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		User saveUser = userService.saveUser(user);
		
		return new ResponseEntity<>("your account is created",HttpStatus.CREATED);
		
	}
	
	
	     
	    // add one record in user table 1st in database then try to login to get JWT token
	    //https://www.codejava.net/frameworks/spring-boot/spring-security-jwt-authentication-tutorial
	    
//	    {
//	    	   "email":"dk@gmail.com",
//	    	    "password":"abcd"
//	    	}
	    
	    @PostMapping("/login")
	    public ResponseEntity<?> login(@RequestBody  AuthRequest request) {
	        try {
	            Authentication authentication = authManager.authenticate(
	                    new UsernamePasswordAuthenticationToken(
	                            request.getEmail(), request.getPassword())
	            );
	             
	            User user = (User) authentication.getPrincipal();
	            String accessToken = jwtUtil.generateAccessToken(user);
	            AuthResponse response = new AuthResponse(user.getEmail(), accessToken);
	             
	            return ResponseEntity.ok().body(response);
	             
	        } catch (BadCredentialsException ex) {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	        }
	    }
	
}
