package com.syc.oa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * 首页控制器,用来实现跳转到home.jsp页面
 */
@Controller
public class IndexController {

	@RequestMapping("/home")
	public String index(){
		
		///WEB-INF/jsp/home.jsp
		return "home";
	}
}
