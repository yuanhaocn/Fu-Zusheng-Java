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
	
	//必须实现该方法,才能加载出商品列表信息!
	//http://localhost:8080/item-list?page=1&rows=0
	//@RequestParams:获取url后面的请求参数部分---page=1&rows=0,是请求参数.
	//@PathVariable:获取url里的请求路径部分---item-list,是请求路径path.
	//跳转到对应的path页面
	//跳到第几页
	@RequestMapping("{path}")
	public String goToPage(@PathVariable String path){
		///WEB-INF/jsp/item-list.jsp
		return path;
	}
}
