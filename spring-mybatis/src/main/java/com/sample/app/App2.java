package com.sample.app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sample.service.PostService;
import com.sample.vo.Post;

public class App2 {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/context.xml");
		
		PostService service = ctx.getBean(PostService.class);
		
		Map<String, Object> param = new HashMap<String, Object>();
		//param.put("deleted", "N");
		param.put("userId", "hong");
		param.put("opt", "title");
		//param.put("keyword", "연습");
		
		List<Post> posts = service.searchPosts(param);
		for(Post post : posts){
			System.out.println(post.getNo() + ", " + post.getTitle() + ", " + post.getUserId());
		}
		
		service.deleteSelectedPosts(List.of(100, 102, 103, 104, 105));
	}
}
