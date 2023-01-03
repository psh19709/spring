package com.sample.controller;

import com.sample.dao.UserOracleDao;

public class UserController {
	
	private UserOracleDao userOracleDao;
	
	public void setUserOracleDao(UserOracleDao userOracleDao) {
		this.userOracleDao = userOracleDao;
	}
	
	public void test() {
		System.out.println("### UserController에 조립된 객체 확인하기");
		System.out.println(userOracleDao);
	}

}
