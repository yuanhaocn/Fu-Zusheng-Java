package com.syc.shiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/home")
	public String home(){
		
		return "home";
	}
	
	@RequestMapping("/403")
	public String to403(){
		
		return "403";
	}
}
