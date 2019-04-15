package com.syc.session.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class IndexServlet
 */
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");

		HttpSession session = request.getSession();

		if (session == null) {
			// 重新去登陆
			response.sendRedirect(request.getContextPath() + "/login.html");
			return;
		}

		String name = (String) session.getAttribute("name");
		String pass = (String) session.getAttribute("pass");

		// 用户名密码为空时,也是未登录的情况
		if (name == null || pass == null) {
			// 重新去登陆
			response.sendRedirect(request.getContextPath() + "/login.html");
			return;
		}

		String html = "";
		html += "<h1>登陆成功!</h1><h3>你好," + name + "</h3><h3>你的密码是:" + pass + "</h3><p><a href='"+request.getContextPath()+"/logout'>点击退出</a></p>";
		response.getWriter().write(html);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
