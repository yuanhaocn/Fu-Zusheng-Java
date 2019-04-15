package com.syc.ssm.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.syc.ssm.domain.User;
import com.syc.ssm.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	@Qualifier("userService")
	private UserService service;
	
	//注册的请求方法
	@RequestMapping("/register")
	public String register(Model model,User user){
		int result = service.registerUser(user);
		if(result>0){
			model.addAttribute("user", user);
			return "/WEB-INF/jsp/success.jsp";
		}
		
		return "/register.jsp";
	}
	
	//登陆方法
	@RequestMapping("/login")
	public String login(HttpSession session,User user){
		User usr = service.login(user);
		if(usr!=null){
			session.setAttribute("user", user);
			return "/WEB-INF/jsp/showUser.jsp";
		}
		return "redirect:login.jsp";
	}
	
	//退出登陆
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();
		System.out.println("退出登陆...");
		return "/login.jsp";
	}
	
}
