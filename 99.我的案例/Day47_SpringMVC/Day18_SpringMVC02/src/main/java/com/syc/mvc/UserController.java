package com.syc.mvc;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
// @RequestMapping("/user")
public class UserController {

	// User参数中的数据如何实现了从表单到JavaBean对象的自动绑定?
	// ServletRequestDataBinder:perform data binding from servlet request
	// parameters to JavaBeans, including support for multipart files.
	@RequestMapping("/editUser")
	public String editUser(Model model, UserVO vo) {

		model.addAttribute("vo", vo);

		// 默认是请求转发,而且默认采用的逻辑视图名!
		return "show";
	}

	// String baseUrl="http://china.huanqiu.com/{model}/{date}/{uuid}.html";

	// String url="http://china.huanqiu.com/article/2017-12-06/11424209.html";
	// String url="http://china.huanqiu.com/army/2017-12-06/11424209.html";
	// String url="http://china.huanqiu.com/sport/2017-12-06/11424209.html";

	// url=http://www.baidu.com:80/index.html----->
	//index.html属于path部分,是要请求的真正的资源路径
	// 根据id,展示对应用户的信息
	// {id}:模板变量
	@RequestMapping(value = "/editUserId/{id}", method = { RequestMethod.POST, RequestMethod.GET })
	public String showUserById(Model model, @PathVariable String id) {
		// @PathVariable:
		// Annotation which indicates that a method parameter
		// should be bound to a URI template variable.
		// 该注解可以将模板变量的值绑定到添加了该注解的参数上面!
		// Supported for RequestMapping annotated handler
		// methods in Servlet environments.

		System.out.println("id=" + id);

		User user = new User();

		// 通过参数动态传进来.
		user.setId(id);
		user.setUsername("三胖");
		user.setAddress("韩国");
		user.setAge(30);
		user.setBirthday(new Date());

		model.addAttribute("user", user);

		return "showById";
	}

	//@PathVariable取出url的path部分里的模板变量的值,然后赋值给方法的形参!
	//restful风格的url地址,优点:设计url的时候非常灵活!
	@RequestMapping(value = "/news/{newsModel}/{date}/{uuid}")
	public String showNews(Model model, @PathVariable String newsModel, @PathVariable String date,
			@PathVariable String uuid) {

		System.out.println("newsModel=" + newsModel);
		System.out.println("date=" + date);
		System.out.println("uuid=" + uuid);
		
		//model.addAttribute("", attributeValue)

		return "showNews";
	}

	
	@InitBinder
	public void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
		// 注册一个自定义的编辑器,进行类型转换.
		// dateFormat:表示在利用binder进行转换的时候,只能识别yyyy-MM-dd类型的字符串.
		// 可以同时注册多个编辑器!
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
		// binder.registerCustomEditor(Date.class, new CustomDateEditor(new
		// SimpleDateFormat("yyyy.MM.dd"), true));
	}
}
