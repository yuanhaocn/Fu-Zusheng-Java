package com.syc.session.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 无论get还是post,去参数值的方法都是一样的的.
		String name = request.getParameter("username");
		String pass = request.getParameter("password");

		if ("syc".equals(name) && "123".equals(pass)) {

			// 将用户信息保存到session中
			HttpSession session = request.getSession();
			session.setAttribute("name", name);
			session.setAttribute("pass", pass);

			//跳转到首页面
			response.sendRedirect(request.getContextPath() + "/index");
		} else {
			// 跳转到一个专门的错误提示页面
			response.sendRedirect(request.getContextPath() + "/fail.html");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
