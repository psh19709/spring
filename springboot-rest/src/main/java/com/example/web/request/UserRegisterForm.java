package com.example.web.request;

import lombok.Data;

@Data
public class UserRegisterForm {
	
	private String id;
	private String password;
	private String name;
	private String email;
	private String tel;

}
