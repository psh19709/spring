package com.sample.app;

import java.util.Date;

import com.sample.vo.User;
import com.sample.vo.User.Builder;

public class App {
	
	public static void main(String[] args) {
		
		Builder builder1 = new User.Builder();
		User user1 = builder1.id("hong")
							.password("zxcv1234")
							.name("홍길동")
							.build();
		
		Builder builder2 = new User.Builder();
		User user2 = builder2.id("kim")
							.name("김유신")
							.age(30)
							.build();
		
		Builder builder3 = new User.Builder();
		User user3 = builder3.id("kang")
							.name("강감찬")
							.tel("010-1111-1111")
							.address("서울시 강남구")
							.birth(new Date())
							.zipcode("02938")
							.build();
	}

}
