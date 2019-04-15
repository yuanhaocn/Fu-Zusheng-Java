package com.syc.oa.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.syc.oa.domain.TbUser;
import com.syc.oa.service.UserService;
import com.syc.oa.vo.PageBean;

@Controller
// @RequestMapping("/user")
public class UserController {

	@Autowired
	@Qualifier("userService")
	private UserService userService;

	/*
	 * 登陆请求
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String loginname, String password, String ishave, HttpServletRequest request,
			HttpServletResponse response) {

		// 判断是否勾选了"记住用户名"
		String options = "remember";

		if (options.equals(ishave)) {// 勾选了"记住用户名"---->添加Cookie
			// 创建Cookie对象
			Cookie nameCookie = new Cookie("loginName", loginname);
			Cookie remCookie = new Cookie("remember", "checked='checked'");
			nameCookie.setMaxAge(Integer.MAX_VALUE);
			remCookie.setMaxAge(Integer.MAX_VALUE);
			// 添加Cookie
			response.addCookie(remCookie);
			response.addCookie(nameCookie);
		} else {// 没有"记住用户名"
				// 清除掉Cookie信息
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie ck : cookies) {
					ck.setMaxAge(0);
					response.addCookie(ck);
				}
			}
		}

		// 真正的登陆操作
		TbUser user = userService.findUserByNameAndPassword(loginname, password);
		if (user != null) {
			// 用户信息存储到Session中
			HttpSession session = request.getSession();
			session.setAttribute("user_session", user);
			session.setMaxInactiveInterval(24 * 60 * 60);

			return "index";
		}

		return "error";
	}

	// 跳转到用户查询界面的请求方法
	@RequestMapping("/user/selectUser")
	public String showUsers() {

		// WEB-INF/jsp/user/user.jsp
		return "user/user";
	}

	/*
	 * 进行用户信息查询 { total:2, rows:[ {....}, {....} ] }
	 */
	@RequestMapping("/userJson")
	@ResponseBody
	public PageBean<TbUser> queryInfo(@RequestParam(defaultValue = "1") Integer pageNumber,
			@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "") String username,
			@RequestParam(defaultValue = "0") String status) {

		System.out.println("page=" + pageNumber + ",size=" + pageSize);
		System.out.println("username=" + username + ",status=" + status);
		return userService.selectAll(username, status);
	}

	/**
	 * 新增用户
	 */
	@RequestMapping("/user/addUser")
	public String addUser(Integer flag, TbUser user, HttpServletResponse response) {
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = response.getWriter();

			if (flag == 1) {// flag=1,跳转到添加用户界面
				return "user/showAddUser";
			} else {
				if (userService.addUser(user)) {
					writer.print("success");
				} else {
					writer.print("error");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 编辑功能
	@RequestMapping("/user/updateUser")
	public String updateUser(Integer flag, Integer id, TbUser user, Model model, HttpServletResponse response) {
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = response.getWriter();

			if (flag == 1) {// 跳转到修改信息页面
				model.addAttribute("user", userService.findUserById(id));
				return "user/showUpdateUser";
			} else {
				System.out.println("id=" + user.getId());
				if (userService.updateUser(user)) {
					writer.print("success");
				} else {
					writer.print("error");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/user/removeUser")
	public String removeUser(Integer flag, Integer id, @RequestParam(value = "ids[]", required = false) Integer[] ids,
			HttpServletResponse response) {

		try {
			PrintWriter writer = response.getWriter();

			boolean result = false;
			if (flag == 1) {// 单个删除
				result = userService.removeOne(id);
				return "user/user";
			} else {// 批量删除
				result = userService.removeMore(ids);
			}

			if (result) {
				writer.print("success");
			} else {
				writer.print("error");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/loginOut")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}
}
