package com.sample.vo;

import org.apache.ibatis.type.Alias;

@Alias("AttachedFile")
public class AttachedFile {

	private int postNo;
	private String fileName;
	public int getPostno() {
		return postNo;
	}
	public void setPostno(int postNo) {
		this.postNo = postNo;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}
