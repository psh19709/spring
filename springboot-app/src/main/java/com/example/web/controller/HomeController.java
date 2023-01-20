package com.example.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.service.UserService;
import com.example.web.request.UserRegisterForm;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	// 홈 화면 요청
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	// 회원가입 화면 요청
	@GetMapping("/register")
	public String registerform() {
		return "register-form";
	}
	
	// 회원가입 처리 요청
	@PostMapping("/register")
	public String register(UserRegisterForm userRegisterForm) {
		userService.registerUser(userRegisterForm);
		return "redirect:registered";
	}
	
	// 회원가입 완료 화면 요청
	@GetMapping("/registered")
	public String success() {
		return "success";
	}
	
	// 로그인 화면 요청
	@GetMapping("/login")
	public String loginform() {
		return "login-form";
	}
	
	@GetMapping("/access-denied")
	public String accessDenied() {
		return "/error/denied";
	}
}
