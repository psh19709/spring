package com.sample.post.dao;

public class ProductOracleDao implements ProductDao{

	@Override
	public void deleteAllProducts() {
		System.out.println("### 오라클 데이터베이스의 상품 테이블에서 모든 상품정보를 삭제함.");
	}
}
