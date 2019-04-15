package com.syc.spring.annotation05.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.syc.spring.annotation05.service.UserService;

@Controller("web")
public class UserController {

	@Autowired
	@Qualifier("service")
	private UserService service;

	public String login() {
		System.out.println("web层登陆...");
		service.login();
		return null;
	}
}
