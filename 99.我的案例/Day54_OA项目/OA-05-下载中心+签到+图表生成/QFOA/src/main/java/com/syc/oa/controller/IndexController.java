package com.syc.oa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页控制器
 * @类名称:IndexController
 * @创建人:SYC
 * @创建时间:2017年10月31日 下午3:48:58
 */
@Controller
public class IndexController {

	@RequestMapping("/home")
	public String index(){
		//逻辑视图名,跳转到/WEB-INF/jsp/home.jsp页面
		return "home";
	}
}
