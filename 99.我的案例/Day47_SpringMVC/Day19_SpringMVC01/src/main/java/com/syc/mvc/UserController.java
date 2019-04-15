package com.syc.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	@RequestMapping("/login")
	public String login(){
		
		System.out.println("Hanlder处理器开始工作...");
		
		return "login";
	}
}
