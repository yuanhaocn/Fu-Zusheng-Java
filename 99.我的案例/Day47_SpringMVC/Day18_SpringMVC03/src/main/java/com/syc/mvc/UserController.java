package com.syc.mvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// @RequestMapping("/user")
public class UserController {

	@RequestMapping("/showUsers")
	public String showUsers(Model model) {

		List<User> users = new ArrayList<User>();

		User usr1 = new User();
		usr1.setId("s001");
		usr1.setUsername("宋江");
		usr1.setAge(38);
		usr1.setAddress("梁山");
		usr1.setBirthday(new Date());

		User usr2 = new User();
		usr2.setId("s002");
		usr2.setUsername("李逵");
		usr2.setAge(28);
		usr2.setAddress("梁山");
		usr2.setBirthday(new Date());

		users.add(usr1);
		users.add(usr2);

		model.addAttribute("users", users);

		// 默认是请求转发.
		//默认情况下,不加"forward"关键词的时候,是按照请求转发,而且默认会按照逻辑视图名的方式
		//去指定的目录下去找指定的资源文件.
		//但是一旦添加了"forward"关键词,就不按照这个规则来走,但是还是请求转发.
		// 重定向:redirect
		//return "showUsers";
		//注意:添加了"forward"关键字,只能按照物理视图名的方式来跳转.
		//return "forward:/WEB-INF/jsp/showUsers.jsp";
		
		//可以从一个Action请求中跳转到另一个Action请求中.
		//return "forward:otherAction.action";
		
		//重定向到其他的Action请求---->可以!
		return "redirect:otherAction.action";
	}
	
	@RequestMapping("/otherAction")
	public String others(){
		
		System.out.println("other....");
		
		return "other";
	}

}
