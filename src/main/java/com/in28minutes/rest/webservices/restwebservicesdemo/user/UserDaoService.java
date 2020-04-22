package com.in28minutes.rest.webservices.restwebservicesdemo.user;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Component;

import antlr.collections.List;

@Component
public class UserDaoService {
	private static ArrayList<User> users = new ArrayList<User>();
	private static Integer counter = 3;
	static {
		users.add(new User(1, "Chan", new Date()));
		users.add(new User(2, "Rohi", new Date()));
		users.add(new User(3, "Chippy", new Date()));
		users.add(new User(4, "Mahesh", new Date()));
		users.add(new User(4, "Mahee", new Date()));
	}
	
	
//	Find All User
	public ArrayList<User> findAll() {
		return users;
	}
	
// Find One User
	public User findOne(int id) {
		for(User user: users) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
		
	}
	
//	Save User
	public User SaveUser(User user) {
		if(user.getId() == null) {
			user.setId(++counter);
		}
		users.add(user);
		return user;
		
	}
}
