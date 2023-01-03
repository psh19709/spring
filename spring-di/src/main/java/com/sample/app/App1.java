package com.sample.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sample.controller.OrderController;
import com.sample.controller.UserController;

public class App1 {
	
	public static void main(String[] args) {
		// 스프링 설정파일의 경로
		String resource = "spring/context-1.xml";
		// 스프링 컨테이너 생성하기
		ApplicationContext ctx = new ClassPathXmlApplicationContext(resource);
		
		// 스프링 컨테이너에서 객체 가져오기
		UserController controller = ctx.getBean(UserController.class);
		controller.test();
		
		OrderController controller2 = ctx.getBean(OrderController.class);
		controller2.test();
		
	}

}
