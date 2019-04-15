package com.syc.servlet.charset;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 解决中文乱码问题
 */
public class CharsetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置请求的编码:解决请求信息中的中文字符串;
		request.setCharacterEncoding("UTF-8");
		//设置响应内容的编码.
		response.setCharacterEncoding("UTF-8");
		//一般会在doGet()或者doPost()方法的一开始就设置输出内容的编码.
		response.setContentType("text/html;charset=UTF-8");
		//setContentType()方法的作用,就是相当于在html页面中写:
		//<meta charset="UTF-8">
		

		// 在JavaEE项目中出现中文乱码问题,原因就在于不同的文件中编码格式不统一!
		// 1.IDE(Eclipse)开发工具有编码问题;
		// 2.项目本身有编码问题;
		// 3.浏览器或者控制台本身有编码问题;
		// 4.外部的文件本身也存在着编码问题.
		// 只需要把以上几部分的编码格式统一了,就不会有乱码.

		System.out.println("中文...");

		PrintWriter writer = response.getWriter();
		writer.write("中文会乱码");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
