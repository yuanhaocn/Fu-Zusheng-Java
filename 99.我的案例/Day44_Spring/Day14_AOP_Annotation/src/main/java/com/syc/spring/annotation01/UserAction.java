package com.syc.spring.annotation01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller("web")
public class UserAction {

	@Autowired
	@Qualifier("service")
	private UserService service;
	
	public void register(){
		System.out.println("web...注册");
		service.register();
	}
}
