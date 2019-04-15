package com.syc.http.request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 如果该Servlet是从login.html页面中跳转过来的,我们就认为用户是一个合法登陆过来的用户;
 * 如果该Servlet不是从login.html页面跳转来的,我们就认为该用户不是一个合法登陆的用户.
 * 
 * @类名称:RequestDemo4Servlet
 * @创建人:SYC
 * @创建时间:2017年7月21日 下午2:40:49
 */
public class RequestDemo4Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = response.getWriter();

		//可以根据该referer的值,来判断一个连接是否合法.
		String referer = request.getHeader("referer");
		if (referer == null||!referer.contains(request.getContextPath()+"/login.html")) {
			// 该servlet前面根本就没有一个url
			writer.write("非法访问!");
			response.setHeader("refresh", "3;url=" + request.getContextPath() + "/login.html");
		} else {
			writer.write("合法访问!");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}