package com.microservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.microservice.entity.User;

@Service
public class UserServiceImpl implements UserService{
	
	private List<User> userList = List.of(
			new User(1,"darshan","darshan@123","Mumbai"),
			new User(2,"aakash","aakash@123","Maysur"),
			new User(3,"prasad","prasad@123","Nashik"),
			new User(4,"abhishek","abhishek@123","Pune"));

	@Override
	public User getUser(int userId) {
		return userList.stream().filter(user -> user.getUserId() == userId).findAny().orElse(new User());
	}

	@Override
	public List<User> getAllUser() {
		return userList;
	}

}
