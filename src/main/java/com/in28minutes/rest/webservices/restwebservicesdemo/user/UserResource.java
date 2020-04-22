package com.in28minutes.rest.webservices.restwebservicesdemo.user;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {
	
	@Autowired
	private UserDaoService userSvc;
	
	
	// retrieve all users
	// GET /users
	@GetMapping(path = "/users")
	public  ArrayList<User> getAllUsers() {
		return userSvc.findAll();
		
	}
	
	// retrive user
	// GET /users/{id}
	@GetMapping(path="users/{id}")
	public User getUser(@PathVariable int id) {
		return userSvc.findOne(id);
		
	}
	
	//Save user
	//POSt /users
//	@PostMapping(path="/users")
//	public onSaveUser() {
//		
//	}

}
