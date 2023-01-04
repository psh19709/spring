package com.sample.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.mapper.PostMapper;
import com.sample.vo.Post;

@Service
public class PostService {
	
	@Autowired
	private PostMapper postMapper;
	
	// 검색하기
	public List<Post> searchPosts(Map<String, Object>param){
		return postMapper.getPosts(param);
	}
	
	// 선택 삭제하기
	public void deleteSelectedPosts(List<Integer> numbers) {
		postMapper.deletePosts(numbers);
	}

}
