package com.sample.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.exception.ApplicationException;
import com.sample.mapper.UserMapper;
import com.sample.mapper.UserRoleMapper;
import com.sample.vo.User;
import com.sample.vo.UserRole;
import com.sample.web.request.UserRegisterForm;

@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserRoleMapper userRoleMapper;
	
	public void registerUser(UserRegisterForm userRegisterForm) {
		User savedUser = userMapper.getUserById(userRegisterForm.getId());
		if(savedUser != null) {
			throw new ApplicationException("["+userRegisterForm.getId()+"] 사용할 수 없는 아이디입니다");
		}
		savedUser = userMapper.getUserByEmail(userRegisterForm.getEmail());
		if(savedUser != null) {
			throw new ApplicationException("["+userRegisterForm.getEmail()+"] 사용할 수 없는 이메일입니다");
		}
		
		// 아이디도 없고 이메일도 등록된 것이 없으면 회원가입이 성공적으로 완료시킨다.
		User user = new User();
		// BeanUtils.copyProperties(Object source, Object target); 
		// 앞에는 소스, 뒤에는 대상 같은 이름(변수명) 에 저장된 값이 저장된다.
		BeanUtils.copyProperties(userRegisterForm, user);
		userMapper.insertUser(user);
		
		// userRole vo객체에는 userId, UserRegisterForm에 저장된 변수명은 id (변수명이 다르다)
		// 등록 할 값이 2개 뿐이라 값을 넣어줘서 저장시킨다.
		UserRole userRole = new UserRole(userRegisterForm.getId(), userRegisterForm.getRoleName());
		userRoleMapper.insertUserRole(userRole);
	}
	
	public void login(String userId, String password) {
		
	}
	
	public void changePassword(String userId, String oldPassword, String password) {
		
	}
	
	public void deleteUser(String userId) {
		
	}
	
	public void addUserRole(UserRole userRole) {
		
	}

}
