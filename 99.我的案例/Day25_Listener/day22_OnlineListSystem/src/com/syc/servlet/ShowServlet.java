package com.syc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syc.entity.User;
import com.syc.service.IUserService;
import com.syc.service.impl.UserService;

/**
 * 信息展示的Servlet
 * 
 * @author 一一哥
 * @Description:
 */
public class ShowServlet extends HttpServlet {

	private static final long serialVersionUID = -7827680361998967928L;

	// 实例化IUserService对象
	private IUserService<User> mService = new UserService();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url;
		try {
			// 调用Service层的查询方法
			List<User> users = mService.findUsers();
			//将users对象存放到request域中
			request.setAttribute("users", users);
			url = "/show.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			url = "/error/error.jsp";
		}

		request.getRequestDispatcher(url).forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
