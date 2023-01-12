package com.sample.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@GetMapping("/testhome")
	public String home() {
		// 내부이동할 뷰페이지 이름을 반환한다.
		return "test/home";
	}

}
