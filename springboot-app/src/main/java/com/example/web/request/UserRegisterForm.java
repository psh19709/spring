package com.example.web.request;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterForm {

	private List<String> roleName;
	private String id;
	private String password;
	private String name;
	private String email;
	private String tel;
}
