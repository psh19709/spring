package com.sample.post.controller;

import com.sample.post.dao.PostDao;

/*
 * PostController는 게시글 등록/조회/ 수정/삭제 요청을 처리하는 컨트롤러다.
 * PostController는 Post 테이블에 대한 데이터엑세스를 수행하기 위해서 PostDao 인터페이스를 구현한 객체가 필요하다.
 * 
 * PostController는 구현클래스 대신 인터페이스 타입의 변수와 Setter 메소드를 정의한다.
 */
public class PostController {
	
	// 게시글 등록시 업로드되는 첨부파일의 저장폴더
	private String saveDirectory;
	// 게시글 등록시 업로드되는 첨부파일의 최대 사이즈
	private long maxUploadSize;

	public void setSaveDirectory(String saveDirectory) {
		this.saveDirectory = saveDirectory;
	}
	
	public void setMaxUploadSize(long maxUploadSize) {
		this.maxUploadSize = maxUploadSize;
	}
	
	// 의존성 주입을 통해서 PostDao구현 객체를 전달받아서 저장하는 변수다
	private PostDao postDao;
	// PostDao 구현객체를 의존성주입으로 전달받기 위해서 정의한 setter메소드다.
	public void setPostDao(PostDao postDao) {
		this.postDao = postDao;
	}
	
	public String savePost() {
		// 요청파라미터값 조회
		// Post객체에 요청파라미터값 저장
		postDao.insertPost();
		
		System.out.println("파일 저장 디렉토리 : " + saveDirectory);
		System.out.println("파일 최대 업로드 사이즈 : " + maxUploadSize);
		
		return "redirect:list.hta";
	}

}
