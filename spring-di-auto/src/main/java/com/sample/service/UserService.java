package com.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sample.dao.PointHistoryDao;
import com.sample.dao.UserDao;

@Service
public class UserService {
	
	/*
	 * @Autowired
	 * 		- 의존성 자동 주입을 지원하는 어노테이션이다.
	 * 		- 멤버변수, Setter 메소드, 생성자 메소드, 메소드의 매개변수에 부착할 수 있다.
	 * 		- 스프링 컨테이너에서 @Autowired 어노테이션 처리하기
	 * 			1. 스프링 컨테이너가 생성한 객체의 클래스에 @Autowired 어노테이션이 있는지 조사한다.
	 * 			2. @Autowired 어노테이션이 지정된 멤버변수의 타입, Setter 메소드 매개변수 타입, 생성자 메소드의 매개변수 타입을 조사한다.
	 * 					@Autowired
	 * 					private UserDao userDao;		// UserDao 타입의 객체에 주입해야한다.
	 * 
	 * 					@Autowired
	 * 					private void setUserDao(UserDao userDao) {		// UserDao 타입의 객체에 주입해야 한다.
	 * 						this.userDao = userDao;
	 * 					}
	 * 				
	 * 					@Autowired
	 * 					private UserService(UserDao userDao, PointHistroyDao pointHistoryDao) {		// UserDao, PointHistoryDao 타입의 객체 주입해야한다.
	 * 						this.userDao userDao;
	 * 						this pointHistroyDao = pointHistoryDao;
	 * 					}
	 * 			3. 스프링 컨테이너가 생성한 객체 조사된 타입과 일치하는 객체 혹은 타입의 자식 객체들 찾아서 주입시킨다.
	 * 			4. 조사된 타입과 일치하거나 혹은 조사된 타입의 자식 객체가 2개 이상 발견되면 오류가 발생한다.
	 * 			5. 조사된 타입과 일치하거나 혹은 조사된 타입의 자식 객체가 2개 이상된 타입이 발견되더라도 
	 * 				@Primary 어노테이션이 부착된 객체가 있다면 해당 객체를 주입시킨다.
	 */
	@Autowired
	private UserDao userDao;
	@Autowired
	private PointHistoryDao pointHistoryDao;
	
	/*
	 * @Value
	 * 		- 기본자료형 타입, 문자열 타입의 값을 의존성 주입으로 전달받아서 변수에 대입시킨다.
	 * 		- 사용법
	 * 			1. properties 파일 생성하기
	 * 				src/main/resources/spring/app.properties 파일 생성, 파일이름은 어떤 이름이던지 상관없다.
	 * 				
	 * 				app.properties
	 * 					# app.properties 파일의 설정값
	 * 					user.doscount.rate=0.002
	 * 					user.defult.profile.filename=default.png
	 * 			2. 빈설정파일에 <context:properties-placeholder />태그 추가하기
	 * 				<context:properties-placeholder location="classpath:spring/app.properties />
	 * 			
	 * 			3. properties 파일의 설정값을 객체의 멤버변수에 주입시키기
	 * 				@Value("${user.discount.rate}")
	 * 				private double discountRate;
	 */
	@Value("${user.defult.profile.filename}")
	private String filename;
	@Value("${user.discount.rate}")
	private double discountRate;
	
	public void config() {
		System.out.println(userDao);
		System.out.println(pointHistoryDao);
		
		System.out.println("고객의 기본 할인율: " + discountRate);
		System.out.println("고객의 기본 프로필이미지 파일명: " + filename);
	}

}
