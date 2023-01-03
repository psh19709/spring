package com.sample.post.dao;

public class PostMySQLDao implements PostDao{

	@Override
	public void insertPost() {
		System.out.println("### MySQL 데이터베이스의 게시글 테이블에 새 게시글 등록함.");
	}
}
