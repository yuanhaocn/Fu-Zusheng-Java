package com.syc.servlet.jump;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 重定向: sendRedirect()
 */
public class SendRedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//重定向的特点:
		//1.重定向可以访问本项目内的资源(静态+servlet);
		//2.重定向可以访问外部的网址,外部网址前面必须有协议名称;
		//3.重定向后,浏览器地址栏中的地址会发生改变;
		//4.重定向不能通过request域来传递数据.
		//5.sendRedirect()方法是response对象的方法.
		
		// 重定向,从当前Servlet----->index.html
		//System.out.println("Path=" + request.getContextPath());
		//response.sendRedirect(request.getContextPath() + "/index.html");
		
		//注意:要访问外网地址的时候,需要在添加http协议名称.
		//response.sendRedirect("www.baidu.com");
		//response.sendRedirect("http://www.baidu.com");
		
		//利用request域在不同的servlet之间传递信息.
		request.setAttribute("name", "Tom");
		
		//从一个Servlet跳转到另一个Servlet.
		response.sendRedirect(request.getContextPath()+"/target");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
