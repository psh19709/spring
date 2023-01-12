package com.sample.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sample.dto.PostDetailDto;
import com.sample.service.PostService;
import com.sample.web.login.LoginUser;
import com.sample.web.login.LoginUserInfo;
import com.sample.web.request.PostRegisterForm;

@Controller
@RequestMapping("/post")
public class PostController {
	
	private final String directory = "c:/files";
	
	@Autowired
	private PostService postService;
	
	@GetMapping("/insert")
	public String postForm() {
		return "post/form";
	}
	
	@PostMapping("/insert")
	public String registerPostForm(@LoginUser LoginUserInfo loginUserInfo, PostRegisterForm postRegisterForm) throws IOException{
		// 첨부 파일 업로드 처리
		MultipartFile upfile = postRegisterForm.getUpfile();
		if(!upfile.isEmpty()) {
			// 첨부 파일 이름을 조회하고, PostRegisterForm 객체에 대입한다.
			String  filename = upfile.getOriginalFilename();
			postRegisterForm.setFilename(filename);
			
			// 첨부파일을 지정된 디렉토리에 저장한다.
			FileCopyUtils.copy(upfile.getInputStream(), new FileOutputStream(new File(directory, filename)));
		}
		
		postService.insertPost(loginUserInfo.getId(), postRegisterForm);
		return "redirect:list";
	}
	
	// 요청 URL - http://localhost/post/list
	//			 http://localhost/post/list?page=2
	@GetMapping("/list")
	public String list(Model model, @RequestParam(name = "page", required = false, defaultValue = "1")int page) {
		Map<String, Object> result = postService.getPosts(page);
		model.addAttribute("posts", result.get("posts"));
		model.addAttribute("pagination", result.get("pagination"));
		
		return "post/list";
	}
	
	// 요청 URL - http://localhost/post/read?postNo=2
	@GetMapping("/read")
	public String read(@RequestParam("postNo") int postNo) {
		postService.increaseReadCount(postNo);
		
		return "redirect:detail?postNo=" + postNo;
	}
	
	// 요청 URL- http://localhost/post/detail?postNo=2
	@GetMapping("/detail")
	public String detail(@RequestParam("postNo") int postNo, Model model) {
		PostDetailDto dto = postService.getPostDetail(postNo);
		model.addAttribute("post", dto);
		
		return "post/detail";
	}
	
	@PostMapping("/insert-comment")
	public String insertComment(@LoginUser LoginUserInfo loginUserInfo,
			@RequestParam("postNo") int postNo,
			@RequestParam("content") String content) {
		
		postService.insertComment(loginUserInfo.getId(), content, postNo);
		
		return "redirect:detail?postNo=" + postNo;
	}

}
