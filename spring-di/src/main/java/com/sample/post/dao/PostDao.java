package com.sample.post.dao;

/*
 * 게시글 테이블에 대한 CRUD 작업을 정의하는 인터페이스다.
 * 게시글 테이블에 대한 CRUD 작업을 구현하는 클래스는 이 인터페이스를 구현해야한다.
 */
public interface PostDao {
	
	/*
	 * void insertPost(Post post)
	 * void deletePost(int postNo)
	 * List<Post> getPosts(Map<String, Object> param);
	 * Post getPostNo(int postNo)
	 * void updatePost(Post post)
	 * ...
	 */
	void insertPost();
}
