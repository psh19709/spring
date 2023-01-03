package com.sample.post.controller;

import com.sample.post.dao.PostDao;
import com.sample.post.dao.ProductDao;

public class ProductController {
	
	// 의존하는 객체에서 구현하고 있는 값을 전달 받기 위해서 인터페이스의 변수를 선언한다.
	// 내가 필요한 객체가 무엇인지 알려주기 위해서다.
	private ProductDao productDao;
	private PostDao postDao;
	
	// 생성자 메소드를 이용해서 의존성 주입받기
	public ProductController(ProductDao productDao, PostDao postDao) {
		this.productDao = productDao;
		this.postDao = postDao;
	}
	public String home() {
		
		productDao.deleteAllProducts();
		postDao.insertPost();
		
		return "home.jsp";
	}

}
