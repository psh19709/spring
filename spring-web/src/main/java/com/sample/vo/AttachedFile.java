package com.sample.vo;

import org.apache.ibatis.type.Alias;

@Alias("AttachedFile")
public class AttachedFile {

	private int postno;
	private String fileName;
	public int getPostno() {
		return postno;
	}
	public void setPostno(int postno) {
		this.postno = postno;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}
