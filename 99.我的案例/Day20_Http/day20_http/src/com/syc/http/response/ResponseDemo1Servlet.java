package com.syc.http.response;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseDemo1Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//设置响应行的状态码
		//response.setStatus(505);
		//发送404错误状态码
		//response.sendError(505);
		
		//setContentType()与下面setHeader(Content-Type)效果一样.
		//response.setHeader("Content-Type", "text/html;charset=UTF-8");
		
		//简化的写法.
		//response.setContentType("text/html;charset=UTF-8");
		
		//实现重定向.sendRedirect()该方法的内部实现,就是302状态+location
		//response.sendRedirect(request.getContextPath()+"/login.html");
		
		//以下两句结合,效果等同于重定向.
		//response.setStatus(302);
		//response.setHeader("location", request.getContextPath()+"/login.html");
		
		//每秒刷新一次页面.定时刷新
		//response.setHeader("refresh", "1");
		//3秒之后做....
		response.setHeader("refresh", "3;url="+request.getContextPath()+"/login.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}