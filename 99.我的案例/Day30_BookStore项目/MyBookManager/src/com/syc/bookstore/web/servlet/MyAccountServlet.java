package com.syc.bookstore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syc.bookstore.domain.User;

/**
 * 我的账户Servlet
 * 
 * @类名称:MyAccountServlet
 * @创建人:SYC
 * @创建时间:2017年7月9日 下午4:57:29
 */
public class MyAccountServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		super.doGet(request, response);

		// 获取register时保存的User信息
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			// 跳转到登陆页面
			response.sendRedirect(request.getContextPath() + "/login.jsp");
		} else {
			String path = "/myAccount.jsp";
			// 如果是管理员用户,则跳转到管理员界面
			if ("admin".equals(user.getRole())) {
				path = "/admin/login/home.jsp";
			}
			request.getRequestDispatcher(path).forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
