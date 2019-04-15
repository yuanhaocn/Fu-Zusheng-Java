package com.syc.struts;

import com.opensymphony.xwork2.ActionSupport;

/*
 * 用户模块
 */
public class UserAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	//对应着注册操作
	public String register(){
		System.out.println("register...");
		return "register";
	}
	
	//对应登陆操作
	public String login(){
		System.out.println("login...");
		return LOGIN;
	}
	
	public String other(){
		
		return "other";
	}
}
