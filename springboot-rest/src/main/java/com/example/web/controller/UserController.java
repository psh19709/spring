package com.example.web.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.UserService;
import com.example.vo.User;
import com.example.web.request.UserRegisterForm;

@RestController
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> users(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/users/{userId}")
	public User getUser(@PathVariable("userId") String userId) {
		
		return userService.getUser(userId);
	}

	@PostMapping("/users")
	public User saveUser(@RequestBody UserRegisterForm userRegisterForm) {
		User user = new User();
		BeanUtils.copyProperties(userRegisterForm, user);
		
		user = userService.saveUser(user);
		
		return user;
	}
	
	@DeleteMapping("/users/{userId}")
	public User deleteUser(@PathVariable("userId") String userId) {
		User user = userService.deleteUser(userId);
		
		return user;
	}
	
	@GetMapping("/users/{userId}/roles")
	public List<String> getUserRoles(@PathVariable("userId") String userId){
		return userService.getUserRoles(userId);
	}
}
