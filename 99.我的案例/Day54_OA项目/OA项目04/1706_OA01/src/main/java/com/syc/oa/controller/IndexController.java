package com.syc.oa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 负责页面跳转
 * @类名称:IndexController
 * @创建人:一一哥
 * @创建时间:2018年2月28日 上午9:32:18
 */
@Controller
public class IndexController {

	@RequestMapping("/home")
	public String home(){
		
		return "home";
	}
}
