package com.sample.web.request;

public class UserRegisterForm {
	
	// 입력폼의 name값과 똑같이 적음 입력값을 표현하는 객체 생성
	private String roleName;
	private String id;
	private String password;
	private String name;
	private String email;
	private String tel;
	
	public UserRegisterForm() {}
	
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "UserRegisterForm [roleName=" + roleName + ", id=" + id + ", password=" + password + ", name=" + name
				+ ", email=" + email + ", tel=" + tel + "]";
	}
	
}
