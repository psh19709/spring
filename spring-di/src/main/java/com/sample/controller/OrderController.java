package com.sample.controller;

import com.sample.dao.OrderOracleDao;
import com.sample.dao.UserOracleDao;

public class OrderController {
	
	private OrderOracleDao orderOracleDao;
	private UserOracleDao userOracleDao;
	
	public void setOrderOracleDao(OrderOracleDao orderOracleDao) {
		this.orderOracleDao = orderOracleDao;
	}
	
	public void setUserOracleDao(UserOracleDao userOracleDao) {
		this.userOracleDao = userOracleDao;
	}
	
	public void test() {
		System.out.println("### OrderController 객체에 조립된 객체 확인하기");
		System.out.println(orderOracleDao);
		System.out.println(userOracleDao);
	}

}
