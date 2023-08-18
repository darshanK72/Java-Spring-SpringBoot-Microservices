package com.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.entity.Contact;
import com.microservice.service.ContactService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ContactController {

    @Autowired
    private ContactService contactService;

    
    @GetMapping("/contact/{contactId}")
    public Contact getContact(@PathVariable("contactId") int contactId)
    {
        return this.contactService.getContact(contactId);
    }

    @GetMapping("/contact")
    public List<Contact> getAllContact()
    {
        return this.contactService.getAllContact();
    }

    @GetMapping("/contact/user/{userId}")
    public List<Contact> getAllContactOfUser(@PathVariable("userId") int userId)
    {
        return this.contactService.getAllContactOfUser(userId);
    }
    
    @GetMapping("/contact/other")
    @HystrixCommand(fallbackMethod = "getFallBack")
    public void other()
    {
    	throw new RuntimeException("Exception Occoured");
    }
    
    public void getFallBack()
    {
    	System.out.println("Contact Service is Down at this time!!!");
    }
}
