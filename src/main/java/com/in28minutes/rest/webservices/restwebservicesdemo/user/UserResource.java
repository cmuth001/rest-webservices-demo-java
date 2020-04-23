package com.in28minutes.rest.webservices.restwebservicesdemo.user;

import java.net.URI;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
		User user = userSvc.findOne(id);
		if(user == null) {
			throw new UserNotFoundException("id= " + id);
		}
		return user;
		
	}
	@DeleteMapping(path="users/{id}")
	public User deleteUser(@PathVariable int id) {
		User user = userSvc.deleteById(id);
		if(user == null) {
			throw new UserNotFoundException("id= " + id);
		}
		return user;
	}
	
	//Save user
	//POSt /users
	@PostMapping(path="/users")
	public  ResponseEntity<Object> createUser(@RequestBody User user){
		System.out.println("-->"+user);
		User savedUser = userSvc.SaveUser(user);
		URI location = ServletUriComponentsBuilder
						.fromCurrentRequest()
						.path("/{id}").buildAndExpand(savedUser.getId())
						.toUri();
		return ResponseEntity.created(location).build();
	}

}
