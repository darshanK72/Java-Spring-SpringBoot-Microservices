package com.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservice.entity.Contact;
import com.microservice.entity.User;
import com.microservice.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	@Autowired
	private RestTemplate restTemplate;
	
	
	@SuppressWarnings("unchecked")
	@GetMapping("/user/{userId}")
	public User getUser(@PathVariable("userId") int userId)
	{
		User user = this.userService.getUser(userId);

		List<Contact> contactList = this.restTemplate.getForObject("http://contact-service/contact/user/" + userId, List.class);

		user.setContactList(contactList);

		return user;
	}
	
	@GetMapping("/user")
	public List<User> getAllUser()
	{
		return this.userService.getAllUser();
	}
	
	@GetMapping("/newother")
	@HystrixCommand(fallbackMethod = "getNewFallBack")
	public void newother()
	{
		throw new RuntimeException("new other exceptino happend");
	}
	
    
    public void getNewFallBack()
    {
    	System.out.println("User Service is Down at this time!!!");
    }

}
