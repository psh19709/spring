package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootRestApplication {

	public static void main(String[] args) {
		// SpringApplication.run() 메소드는 스프링 컨테이너 객체를 생성하고 반환한다.
		// SpringApplication.run() 메소드의 매개변수로 전달된 클래스에 @SpringBootApplication 어노테이션이 지정되어 있기 때문에
		// spring boot의 자동구성이 수행된다.
		SpringApplication.run(SpringbootRestApplication.class, args);
	}

}
