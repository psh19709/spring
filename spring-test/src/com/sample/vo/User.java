package com.sample.vo;

import java.util.Date;

public class User {
	
	private String id;
	private String password;
	private String name;
	private String email;
	private String tel;
	private int age;
	private Date birth;
	private String zipcode;
	private String address;
	private boolean enabled;
	
	private User() {}

	public String getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getTel() {
		return tel;
	}
	public int getAge() {
		return age;
	}
	public Date getBirth() {
		return birth;
	}
	public String getZipcode() {
		return zipcode;
	}
	public String getAddress() {
		return address;
	}
	public boolean isEnabled() {
		return enabled;
	}
	
	public static class Builder {
		private String id;
		private String password;
		private String name;
		private String email;
		private String tel;
		private int age;
		private Date birth;
		private String zipcode;
		private String address;
		private boolean enabled;
		
		public Builder() {}
		
		public Builder id(String id) {
			this.id = id;
			return this;
		}
		public Builder password(String password) {
			this.password = password;
			return this;
		}
		public Builder name(String name) {
			this.name = name;
			return this;
		}
		public Builder email(String email) {
			this.email = email;
			return this;
		}
		public Builder tel(String tel) {
			this.tel = tel;
			return this;
		}
		public Builder age(int age) {
			this.age = age;
			return this;
		}
		public Builder birth(Date birth) {
			this.birth = birth;
			return this;
		}
		public Builder zipcode(String zipcode) {
			this.zipcode = zipcode;
			return this;
		}
		public Builder address(String address) {
			this.address = address;
			return this;
		}
		public Builder enabled(Boolean enabled) {
			this.enabled = enabled;
			return this;
		}
		
		public User build() {
			User user = new User();
			user.id = this.id;
			user.password = this.password;
			user.name = this.name;
			user.email = this.email;
			user.tel = this.tel;
			user.age = this.age;
			user.birth = this.birth;
			user.zipcode = this.zipcode;
			user.address = this.address;
			user.enabled = this.enabled;
			
			return user;
		}
		
	}
	

}
