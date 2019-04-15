package com.syc.servlet.jump;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 请求转发的方法. 请求转发对象 RequestDispatcher
 * dispather=request.getRequestDispatcher(path)
 */
public class ForwardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// RequestDispatcher dispatcher = request.getRequestDispatcher("");

		// 请求转发的特点:
		//1.请求转发的跳转方式,只能访问内部资源(html,servlet),而且只需要写内部资源的名称,不需要写完整路径.
		//2.请求转发的跳转方式,不能访问外部url地址;
		//3.请求转发的跳转方式,浏览器地址栏里的地址跳转前后内容不会发生改变;
		//4.请求转发的跳转方式,request域可以实现信息从一个Servlet传递到另一个Servlet中.
		//5.request.getRequestDispatcher()是request对象的方法.
		
		// RequestDispatcher dispatcher =
		// request.getRequestDispatcher("/index.html");
		// 前进....
		// dispatcher.forward(request, response);

		//请求转发
		//请求转发,如果是完整的内部资源路径,无法实现跳转.
		//request.getRequestDispatcher(request.getContextPath()+"/index.html").forward(request, response);
		//request.getRequestDispatcher("/index.html").forward(request, response);
		
		//请求转发无法跳转到外部url地址.
		//request.getRequestDispatcher("http://www.baidu.com").forward(request, response);
		
		//请求转发的跳转方式,request域可以实现信息传递到另一个Servlet中.
		request.setAttribute("name", "Tom");
		
		//请求转发可以跳转到另一个servlet中.
		request.getRequestDispatcher("/target").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
