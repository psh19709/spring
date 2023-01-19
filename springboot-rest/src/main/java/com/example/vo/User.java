package com.example.vo;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//mybatis의 어노테이션
@Alias("User")
// lombok 어노테이션
// @Data 자동으로 gettet setter toString 등등 자동으로 생성됨.
// @Data
@Getter
@Setter
@ToString
@NoArgsConstructor
public class User {
	
	private String id;
	@JsonIgnore
	private String password;
	private String name;
	private String email;
	private String tel;
	@JsonIgnore
	private String photo;
	private String deleted;
	@JsonFormat(pattern = "yyyy.M.d.")
	private Date createdDate;
	@JsonFormat(pattern = "yyyy.M.d.")
	private Date updatedDate;

}
