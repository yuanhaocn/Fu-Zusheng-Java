package com.syc.oa.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.syc.oa.domain.TbUser;
import com.syc.oa.service.UserService;

/**
 * 用户管理模块
 * @类名称:UserController
 * @创建人:一一哥
 * @创建时间:2018年2月27日 下午2:10:10
 */
@Controller
//@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	/**
	 * login请求方法
	 */
	@RequestMapping(name="login",method=RequestMethod.POST)
	public String login(String loginName,String password,String ishave,HttpServletRequest request,HttpServletResponse response){
		
		if("remember".equals(ishave)){//勾选了记住用户名
			//创建Cookie
			Cookie nameCk=new Cookie("loginName", loginName);
			Cookie remCk=new Cookie("remember", "checked='checked'");
			nameCk.setMaxAge(Integer.MAX_VALUE);
			remCk.setMaxAge(Integer.MAX_VALUE);
			//把Cookie对象输出到浏览器进行保存
			response.addCookie(nameCk);
			response.addCookie(remCk);
		}else{
			Cookie[] cookies = request.getCookies();
			if(cookies!=null){
				for(Cookie ck : cookies){
					ck.setMaxAge(0);
					response.addCookie(ck);
				}
			}
		}
		
		//实现登陆操作
		TbUser user = userService.findUserByNameAndPassword(loginName, password);
		if(user!=null){
			HttpSession session = request.getSession();
			session.setAttribute("user_session", user);
			session.setMaxInactiveInterval(24*60*60);
			
			return "index";
		}
		
		return "error";
	}
}
