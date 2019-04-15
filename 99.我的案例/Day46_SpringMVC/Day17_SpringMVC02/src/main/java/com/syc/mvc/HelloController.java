package com.syc.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/*
 * 控制器/处理器
 */
public class HelloController implements Controller{

	//处理http请求,并且做出响应
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ModelAndView mv=new ModelAndView();
		
		//封装要存储的数据,就等同于在request域中存储了一个信息.
		mv.addObject("msg", "这是要被传递的信息....");
		
		//设置视图名称
		//设置要跳转到的资源位置,跳转到指定的视图位置上
		//默认情况下,请求方式是请求转发.
		mv.setViewName("/WEB-INF/jsp/index.jsp");
		
		return mv;
	}

}
