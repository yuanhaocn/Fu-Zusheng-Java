package com.syc.mvc;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	//HttpServletReqeust,HttpServletResponse,HttpSession,Model,ModelMap,JavaBean等,
	//对于这几个类型来说,只要在控制器的方法中,直接写该类型,SpringMVC会自动给他们注入值!
	@RequestMapping("/login")
	public String login(HttpSession session,User user){
		
		//HttpSession session=ServletActionContext.getRequest().getSession();
		
		session.setAttribute("user", user);
		
		return "show";
	}
	
	//退出登陆
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		
		session.invalidate();
		
		//重定向到登陆页面
		return "redirect:login.jsp";
	}
}
