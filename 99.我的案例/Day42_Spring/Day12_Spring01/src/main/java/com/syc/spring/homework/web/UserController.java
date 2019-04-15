package com.syc.spring.homework.web;

import com.syc.spring.homework.service.UserService;

public class UserController {

	private UserService service;
	
	public void setService(UserService service) {
		this.service = service;
	}

	public String login() {

		System.out.println("web层登陆...");
		service.login();
		return null;
	}
}
