package com.sample.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sample.dto.UserDetailDto;
import com.sample.exception.ApplicationException;
import com.sample.service.UserService;
import com.sample.utils.SessionUtils;
import com.sample.web.login.LoginUserInfo;

@Controller
@RequestMapping("/user")

public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/info")
	public String info(Model model) {
		
		LoginUserInfo loginUserInfo = (LoginUserInfo)SessionUtils.getAttribute("loginUser");
		if(loginUserInfo == null) {
			throw new ApplicationException("로그인 정보가 존재하지 않습니다.");
		}
		
		UserDetailDto userDetailDto = userService.getUserDetail(loginUserInfo.getId());
		model.addAttribute("user", userDetailDto);
		
		return"user/detail";
	}

}
