package com.syc.oa.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.syc.oa.domain.TbUser;
import com.syc.oa.service.UserService;
import com.syc.oa.vo.PageBean;

/**
 * 用户管理模块
 * 
 * @类名称:UserController
 * @创建人:一一哥
 * @创建时间:2018年2月27日 下午2:10:10
 */
@Controller
// @RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * login请求方法
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(String loginName, String password, String ishave, HttpServletRequest request,
			HttpServletResponse response) {

		if ("remember".equals(ishave)) {// 勾选了记住用户名
			// 创建Cookie
			Cookie nameCk = new Cookie("loginName", loginName);
			Cookie remCk = new Cookie("remember", "checked='checked'");
			nameCk.setMaxAge(Integer.MAX_VALUE);
			remCk.setMaxAge(Integer.MAX_VALUE);
			// 把Cookie对象输出到浏览器进行保存
			response.addCookie(nameCk);
			response.addCookie(remCk);
		} else {
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie ck : cookies) {
					ck.setMaxAge(0);
					response.addCookie(ck);
				}
			}
		}

		// 实现登陆操作
		TbUser user = userService.findUserByNameAndPassword(loginName, password);
		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user_session", user);
			session.setMaxInactiveInterval(24 * 60 * 60);

			return "index";
		}

		return "error";
	}

	/**
	 * 跳转到用户查询界面
	 */
	@RequestMapping("/user/selectUser")
	public String showUsers() {

		return "user/user";
	}

	/**
	 * 实现真正的查询操作. 前后端json对象和Java对象之间需要进行互相转换,有2种方式可以转换:
	 * ①.在mvc中配置转换器:FastJson,JackSon,GSON等的转换器;
	 * ②.先在Java的后端将Java对象转换为JSON对象,然后再将该对象输出到前端.
	 */
	@RequestMapping("/userJson")
	@ResponseBody
	public PageBean<TbUser> queryUsers(@RequestParam(defaultValue = "1") Integer pageNumber,
			@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "") String username,
			@RequestParam(defaultValue = "0") String status) {

		// System.out.println(
		// "pageNum=" + pageNumber + ",pageSize=" + pageSize + ",username=" +
		// username + ",status=" + status);

		return userService.selectAll(username, status);
	}

	/**
	 * 实现添加用户
	 * 
	 * @throws IOException
	 */
	@RequestMapping("/user/addUser")
	public String addUser(Integer flag, TbUser user, HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = response.getWriter();

		if (flag == 1) {// flag==1,表示单纯的实现跳转
			return "user/showAddUser";
		} else {
			if (userService.addUser(user)) {
				writer.print("success");
			} else {
				writer.println("error");
			}
		}

		return null;
	}

	/**
	 * 实现用户的修改
	 * 
	 * @throws IOException
	 */
	@RequestMapping("/user/updateUser")
	public String updateUser(Integer flag, Integer id, TbUser user, Model model, HttpServletResponse response)
			throws IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		if (flag == 1) {
			model.addAttribute("user", userService.findUserById(id));
			return "user/showUpdateUser";
		} else {
			if (userService.updateUser(user)) {
				writer.print("success");
			} else {
				writer.print("error");
			}
		}
		return null;
	}

	@RequestMapping("/user/removeUser")
	public String removeUser(Integer flag, Integer id, @RequestParam(value = "ids[]", required = false) Integer[] ids,
			HttpServletResponse response) throws IOException {
		
		PrintWriter writer = response.getWriter();

		boolean result=false;
		if (flag == 1) {// 单个删除
			result = userService.removeOne(id);
			return "user/user";
		} else {// 批量删除
			result = userService.removeMore(ids);
		}
		
		if(result){
			writer.print("success");
		}else{
			writer.print("error");
		}
		
		return null;
	}

}
