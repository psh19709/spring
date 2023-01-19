package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.vo.User;

@Mapper
public interface UserMapper {
	
	void insertUser(User user);
	List<User> getUsers();
	User getUserById(String userId);
	User getUserByEmail(String email);
	void updateUser(User user);
	void deleteUser(String userId);
	List<String> getUserRoles(String userId);

}
