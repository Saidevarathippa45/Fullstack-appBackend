package com.SecondApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SecondApp.model.User;
import com.SecondApp.service.userService;

@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:3000")
public class HomeController {

	@Autowired
	userService userservice;
	@PostMapping("/adduser")
	public String registerUser(@RequestBody User user) {
		userservice.registerUser(user);
		System.out.println("im in controller");
		return "user added Successfully";
	}
	
	@GetMapping("/getAllUsers")
	public List<User> getAll(){
		
		return userservice.getAll();
	}
	@DeleteMapping("/delete/{userId}")
	public String deleteUser(@PathVariable("userId") long userId) {
		userservice.deleteUser(userId);
		System.out.println("im in controller");
		return "user deleted successfully";
		
	}
}
