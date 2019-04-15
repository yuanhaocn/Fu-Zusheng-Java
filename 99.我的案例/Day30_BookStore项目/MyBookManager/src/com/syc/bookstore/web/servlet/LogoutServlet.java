package com.syc.bookstore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 退出登陆
 * 
 * @类名称:LogoutServlet
 * @创建人:SYC
 * @创建时间:2017年7月9日 下午6:15:11
 */
public class LogoutServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		super.doGet(request, response);

		// 使得Session过期失效
		request.getSession().invalidate();
		// 重定向与转发都可以
		response.sendRedirect(request.getContextPath() + "/index.jsp");
		// request.getRequestDispatcher("/index.jsp").forward(request,
		// response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
