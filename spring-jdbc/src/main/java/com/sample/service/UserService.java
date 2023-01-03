package com.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.dao.UserDao;
import com.sample.vo.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	// 회원가입
	/*
	 * 회원가입 업무로직
	 * 		- 동일한 아이디로 가입한 사용자가 있는지 확인
	 * 		- 동일한 이메일로 가입한 사용자가 있는지 확인
	 * 		- 위의 조건에 해당하는 사용자가 없으면 회원정보를 데이터베이스에 저장시킨다.
	 */
	public void registerUser(User user) {
		User savedUser = userDao.getUserById(user.getId());
			if(savedUser != null) {
				throw new RuntimeException("["+user.getId()+"]는 사용할 수 없는 아이디입니다.");
			}
			
		savedUser = userDao.getUserByEmail(user.getEmail());
		if(savedUser != null) {
			throw new RuntimeException("["+user.getEmail()+"]는 사용할 수 없는 이메일입니다.");
		}
		
		userDao.insertUser(user);
	}
	
	// 비밀번호 변경
	/*
	 * 비밀번호 변경하기 업무로직
	 * 		- 사용자 아이디로 사용자 정보가 존재하는지 확인하기
	 * 		- 사용자의 비밀번호와 이전 비밀번호가 서로 일치하는지 확인하기
	 * 		- 사용자의 비밀번호가 일치하면 사용자의 비밀번호를 변경한다.
	 */
	public void changeUserPassword(String userId, String oldPassword, String password) {
		User savedUser = userDao.getUserById(userId);
		if(savedUser == null) {
			throw new RuntimeException("["+userId+"]로 사용자정보를 찾을 수 없습니다.");
		}
		if(!savedUser.getPassword().equals(oldPassword)) {
			throw new RuntimeException("비밀번호가 일치하지 않습니다.");
		}
		
		savedUser.setPassword(password);
		userDao.updateUser(savedUser);
	}

}
