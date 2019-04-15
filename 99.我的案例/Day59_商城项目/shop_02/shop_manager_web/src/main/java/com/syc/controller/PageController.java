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
	//跳到第几页
	@RequestMapping("{page}")
	public String goToPage(@PathVariable String page){
		return page;
	}
}
