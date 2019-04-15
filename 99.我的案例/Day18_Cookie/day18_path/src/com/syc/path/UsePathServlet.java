package com.syc.path;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UsePathServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");

		// JavaEE中使用路径的几个地方:
		// 1.请求转发:(只能访问本项目内的资源,html+jsp+servlet等).
		// request.getContextPath():获取本项目的名称,/day18_path
		// /day18_path/day18_path/target.html
		// 这样写不对.
		// request.getRequestDispatcher(request.getContextPath() +
		// "/target.html").forward(request, response);
		// request.getRequestDispatcher("/target.html").forward(request,
		// response);

		// 2.重定向:
		// http://localhost:8080/target.html
		// response.sendRedirect("/target.html");
		// response.sendRedirect(request.getContextPath()+"/target.html");

		PrintWriter writer = response.getWriter();

		// 3.<a></a>超链接:
		// writer.write("<a href='/target.html'>跳转</a>");
		// writer.write("<a href='/day18_path/target.html'>跳转</a>");
		// writer.write("<a
		// href='"+request.getContextPath()+"/target.html'>跳转</a>");

		// 4.<form></form>表单提交:
		writer.write("<form method='post' action='" + request.getContextPath()
				+ "/target.html'> 用户名:<input type='text'/> <input type='submit' value='提交'/>  </form>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
