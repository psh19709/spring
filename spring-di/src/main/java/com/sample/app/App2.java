package com.sample.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sample.post.controller.PostController;
import com.sample.post.controller.ProductController;

public class App2 {
	
	public static void main(String[] args) {
		// 스프링 빈 설정파일의 경로다.
		String resource = "spring/context-2.xml";
		// ClassPathXmlApplicationContext는 스프링 컨테이너 역할을 수행하는 클래스다.
		// ClassPathXmlApplicationContext는 스프링 빈 설정파일의 설정정보를 분석해서 객체를 생성 조립 관리한다.
		ApplicationContext ctx = new ClassPathXmlApplicationContext(resource);
		
		//.getBean(Class<?> classType)은 스프링 컨테이너에서 해당 클래스타입의 객체를 검색해서 반환한다.
		PostController controller = ctx.getBean(PostController.class);
		// PostController객체의 savePost메소드 실해
		controller.savePost();
		
		ProductController c = ctx.getBean(ProductController.class);
		c.home();
	}

}
