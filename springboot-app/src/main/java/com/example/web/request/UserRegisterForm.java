package com.example.web.request;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterForm {

	@Size(min = 1, message = "접속권한은 하나 이상 선택해주세요")
	private List<String> roleName;
	@NotBlank(message = "아이디는 필수입력값입니다.")
	@Size(min = 4, max=20, message="아이디는 4글자 이상 20글자 미만이여야 합니다.")
	private String id;
	
	@NotBlank(message = "비밀번호는 필수입력값입니다.")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$", message = "비밀번호는 최소 8자, 대문자 하나 이상, 소문자 하나 이상 및 숫자 하나 이상이 포함되어야 합니다.")
	private String password;
	
	@NotBlank(message = "이름은 필수입력값입니다.")
	@Pattern(regexp = "^[가-힣]{2,}$", message = "이름은 한글 2글자 이상으로 입력하세요.")
	private String name;
	
	@NotBlank(message = "이메일은 필수입력값입니다.")
	@Email(message = "유효한 이메일 형식이 아닙니다.")
	private String email;
	
	@NotBlank(message = "전화번호는 필수입력값입니다.")
	@Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "유효한 전화번호 형식이 아닙니다.")
	private String tel;
}
