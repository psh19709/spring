package com.sample.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.mapper.UserMapper;
import com.sample.vo.User;

@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	// 회원가입
	public void registerUser(User User) {
		
	}
	
	// 로그인
	public void login(String userId, String password) {
		
	}
	
	// 내 정보 보기
	public User getUserInfo(String userId) {
		User user = userMapper.getUserById(userId);
		if(user == null) {
			throw new RuntimeException("["+userId+"] 회원정보가 존재하지 않습니다.");
		}
		return user;
	}
	
	// 회원리스트 조회
	public List<User> getAllUsers(Map<String, Object> param) {
		return userMapper.getUsers(param);
	}

}
