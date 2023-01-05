package com.sample.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sample.service.UserService;
import com.sample.web.request.UserRegisterForm;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/home")
	public String home() {
		// 내부이동할 뷰페이지 이름을 반환한다.
		return "home";
	}
	
	@GetMapping("/register")
	public String registerform() {
		// 내부이동할 뷰페이지 이름을 반환한다.
		return "register-form";
	}
	
	@PostMapping("/register")
	public String register(UserRegisterForm userRegisterForm) {
		userService.registerUser(userRegisterForm);
		return "redirect:success";
	}
	
	@GetMapping("/login")
	public String loginform() {
		return "login-form";
	}
	
}
