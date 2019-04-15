package com.syc.http.response;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseDemo3Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");

		// IllegalStateException: getWriter() has already been called for this
		// response
		// PrintWriter writer = response.getWriter();
		// 可以输出字符串,字符数组,int.
		// writer.write("sssss");

		ServletOutputStream out = response.getOutputStream();
		// 只能输出字节
		out.write("中文".getBytes());

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}