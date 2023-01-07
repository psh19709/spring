package com.sample.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.dto.UserDetailDto;
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
	
	public User login(String userId, String password) {
		User savedUser = userMapper.getUserById(userId);
		if(savedUser == null) {
			throw new ApplicationException("아이디 혹은 비밀번호가 올바르지 않습니다.");
		}
		if("Y".equals(savedUser.getDeleted())) {
			throw new ApplicationException("탈퇴처리된 사용자 계정으로 로그인 할 수 없습니다.");
		}
		if(!savedUser.getPassword().equals(password)) {
			throw new ApplicationException("아이디 혹은 비밀번호가 올바르지 않습니다.");
		}
		return savedUser;
	}
	
	public UserDetailDto getUserDetail(String userId) {
		// 사용자 정보 조회
		User user = userMapper.getUserById(userId);
		// 사용자의 권한 정보 조회
		List<UserRole> userRoles = userRoleMapper.getUserRolesByUserId(userId);

		// 사용자정보와 권한정보를 모두 저장하는 UserDetailDto 객체생성
		UserDetailDto userDetailDto = new UserDetailDto();
		// User객체의 값을 UserDetailDto 객체로 복사하기
		BeanUtils.copyProperties(user, userDetailDto);
		//사용자권한정보를 UserDetailDto 객체에 저장하기
		userDetailDto.setUserRoles(userRoles);
		
		return userDetailDto;
	}
	
	public void changePassword(String userId, String oldPassword, String password) {
		
	}
	
	public void deleteUser(String userId) {
		
	}
	
	public void addUserRole(UserRole userRole) {
		
	}

}
