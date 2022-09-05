package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.user.entity.Contact;
import com.user.entity.User;
import com.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/{userId}")
	public ResponseEntity<User> getUser(@PathVariable("userId") Long id){
		
		User user = this.userService.getUser(id);
		@SuppressWarnings("unchecked")
		List<Contact> contacts = this.restTemplate.getForObject("http://contact-service/contact/user/"+user.getUserId(), List.class);
		user.setContacts(contacts);
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
}
