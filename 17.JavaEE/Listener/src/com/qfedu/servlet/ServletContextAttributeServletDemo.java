package com.qfedu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servletContextAttributeServletDemo")
public class ServletContextAttributeServletDemo extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//添加域对象的值
		getServletContext().setAttribute("name", "骆之玉");
	//5秒之后修改域对象的值
		try {
			Thread.sleep(5000);
			getServletContext().setAttribute("name", "傅祖升");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	//5秒之后删除域对象的值
		try {
			Thread.sleep(5000);
			getServletContext().removeAttribute("name");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
