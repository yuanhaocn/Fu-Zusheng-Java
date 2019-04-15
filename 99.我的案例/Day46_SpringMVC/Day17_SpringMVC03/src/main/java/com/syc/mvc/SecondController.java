package com.syc.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class SecondController implements Controller{

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv=new ModelAndView();
		
		mv.addObject("msg", "Controller里的信息");
		
		//实现跳转的
		//物理视图名---->真实的视图名
		//mv.setViewName("/WEB-INF/jsp/index.jsp");
		
		//逻辑视图名,该名称是jsp文件的名称,不包括后缀!
		mv.setViewName("index");
		
		return mv;
	}

}
