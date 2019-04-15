package com.syc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FirstServlet() {

	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, resp);
	}

	//doGet()用来处理get请求;
	//request:浏览器向服务器发起请求;
	//利用request获取浏览器发来的请求参数;
	//response:服务器向浏览器进行响应.
	//利用response向浏览器输出一些内容.
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//内容输出
		PrintWriter writer = response.getWriter();
		writer.write("Hello,Servlet");
		//向浏览器页面输出内容
		//writer.write(buf);
		//writer.println(x);
		//writer.print(s);
		//writer.append(csq)
	}

	//用来处理post请求.
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
