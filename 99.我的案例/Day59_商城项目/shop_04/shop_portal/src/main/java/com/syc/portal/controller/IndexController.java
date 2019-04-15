package com.syc.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	//展示index首页
	@RequestMapping("/index")
	public String goToIndex(){
		return "index";
	}
}
