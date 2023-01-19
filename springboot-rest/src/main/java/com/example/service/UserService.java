package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.mapper.UserMapper;
import com.example.vo.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	//@Autowired
	//private UserMapper userMapper;
	
	private final UserMapper userMapper;
	
	public List<User> getAllUsers(){
		return userMapper.getUsers();
	}
	
	public User getUser(String userId) {
		return userMapper.getUserById(userId);
	}

	public User saveUser(User user) {
		// id, email 중복체크 코드는 생락(원래는 필수)
		userMapper.insertUser(user);
		return userMapper.getUserById(user.getId());
	}

	public User deleteUser(String userId) {
		User user = userMapper.getUserById(userId);
		user.setDeleted("Y");
		userMapper.updateUser(user);
		
		return userMapper.getUserById(userId);
	}

	public List<String> getUserRoles(String userId){
		return userMapper.getUserRoles(userId);
	}
}
