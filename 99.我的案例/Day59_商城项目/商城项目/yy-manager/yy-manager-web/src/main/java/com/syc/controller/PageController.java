package com.syc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

	//跳转到首页
	@RequestMapping("/")
	public String toIndex(){
		//WEB-INF/jsp/index.jsp
		return "index";
	}
	
	//protocol://host:port/path
	//http://localhost:8080/item-list?page=1&rows=30
	//@RequestParams:获取url后面的请求参数部分---page=1&rows=0,是请求参数.
	//@PathVariable:获取url里的请求路径部分---item-list,是请求路径path.
	//跳转到对应的path页面
	@RequestMapping("{path}")//rest
	public String goToPath(@PathVariable String path){
		///WEB-INF/jsp/item-list.jsp
		//return "item-add";///WEB-INF/jsp/item-add.jsp
		return path;
	}
}
