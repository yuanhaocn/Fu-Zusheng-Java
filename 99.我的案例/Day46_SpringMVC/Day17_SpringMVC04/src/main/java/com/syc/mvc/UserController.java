package com.syc.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * 创建控制器:
 * 1.实现Controller接口----------->实现handleRequest()方法.
 * 2.实现HttpRequestHandler接口;-->实现handleRequest()方法.
 * 3.什么接口都不实现!
 */

/*
 * @RequestMapping:如果作用在类上,效果等同于struts2中的namespace属性!
 * @RequestMapping:如果作用在方法上,效果等同于struts2中的action中的name+method!
 */
@Controller
@RequestMapping("/user")
public class UserController {

	//http://localhost:8080/项目名/register.action
	//Model:可以理解成是MVC中的M,它可以用来存储数据,相当于是Map.
	//ModelAndView:
	@RequestMapping("/register")
	public String register(Model model){
		System.out.println("register....");
		
		//可以转换成对应的Map对象
		//Map<String, Object> asMap = model.asMap();
		model.addAttribute("msg", "传递的信息...");
		
		//return "/WEB-INF/jsp/register.jsp";
		//逻辑视图名
		//默认的请求方式还是请求转发.
		return "register";
	}
	
	//http://localhost:8080/项目名/login.action
	@RequestMapping("/login")
	public String login(Model model){
		System.out.println("login...");
		
		User user=new User();
		user.setId(1);
		user.setUsername("Tom");
		user.setPassword("123");
		
		model.addAttribute("user", user);
		
		//request.setAttribute(model);
		
		//return "/WEB-INF/jsp/login.jsp";
		return "login";
	}
}
