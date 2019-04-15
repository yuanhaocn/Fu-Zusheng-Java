package com.syc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * 分页的控制器
 */
@Controller
public class PageController {

	//显示首页
	@RequestMapping("/")
	public String toIndex(){
		return "index";
	}
	
	//获取url后面的请求路径path,比如获取http://localhost:8080/item-list?page=1&rows=0
	//的item-list部分,这一部分是path路径.
	//跳转到item-list.jsp页面中.
	@RequestMapping("{path}")
	public String goToPage(@PathVariable String path){
		return path;
	}
}
