package com.syc.commons.pojo;

import java.io.Serializable;

//根据easyui的异步树需要的json格式封装的实体类
public class EasyUITreeNode implements Serializable {
	
	private long id;
	private String text;
	private String state;	
	
	public String getText() {
		return text;
	}
	
	public String getState() {
		return state;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
