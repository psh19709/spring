package com.sample.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.sample.vo.User;

@Mapper
public interface UserMapper {
	
	void insertUser(User user);
	void updateUser(User user);
	List<User> getUsers(Map<String, Object> param);
	User getUserById(String id);
	User getUserByEmail(String email);

}
