package com.sample.app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sample.service.UserService;
import com.sample.vo.User;

public class App {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/context.xml");

		UserService userService = ctx.getBean(UserService.class);
		
		System.out.println("UserService의 내 정보 조회하기 기능 실행");
		User user = userService.getUserInfo("hong");
		System.out.println(user.getId());
		System.out.println(user.getPassword());
		System.out.println(user.getName());
		System.out.println(user.getEmail());
		
		System.out.println("### UserService의 회원 조회 기능 실행");
		Map<String, Object> param = new HashMap<String, Object>();
		//param.put("enabled", "Y");
		
		List<User> users = userService.getAllUsers(param);
		for(User u : users) {
			System.out.println(u.getId() + ", " + u.getName() + ", " + u.getEmail());
		}
		
	}

}
