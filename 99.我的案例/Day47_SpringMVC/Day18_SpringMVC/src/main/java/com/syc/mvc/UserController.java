package com.syc.mvc;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// @RequestMapping("/user")
public class UserController {

	//User参数中的数据如何实现了从表单到JavaBean对象的自动绑定?
	//ServletRequestDataBinder:perform data binding from servlet request parameters to JavaBeans, including support for multipart files.
	@RequestMapping("/editUser")
	public String editUser(Model model, User user) {

		// request.getParameter("username");
		
		String username = user.getUsername();
		System.out.println("username="+username);

		model.addAttribute("user", user);

		// 默认是请求转发,而且默认采用的逻辑视图名!
		return "show";
	}
	
	//该注解的作用,是使得该方法称为一个initBinder方法,
	//我们就可以在该方法中,进行类型转换工作.
	//binder:将request中的请求参数自动填充到JavaBean对应的属性中!
	//perform data binding from servlet request parameters to JavaBeans, including support for multipart files. 
	@InitBinder
	public void initBinder(HttpServletRequest request,ServletRequestDataBinder binder){
		//注册一个自定义的编辑器,进行类型转换.
		//dateFormat:表示在利用binder进行转换的时候,只能识别yyyy-MM-dd类型的字符串.
		//可以同时注册多个编辑器!
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy.MM.dd"), true));
	}
}
