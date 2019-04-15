package com.syc.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 实现页面跳转
 * @类名称:IndexController
 * @创建人:一一哥
 * @创建时间:2018年3月13日 上午10:30:51
 */
@Controller
public class IndexController {

	@RequestMapping("/index")
	public String index(){
		
		return "index";
	}
	
	@RequestMapping("/home")
	public String home(){
		
		return "home";
	}
}

