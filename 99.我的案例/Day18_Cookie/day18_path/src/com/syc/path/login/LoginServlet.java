package com.syc.path.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = response.getWriter();

		// 取出请求参数中的内容
		// String name = request.getParameter("username");
		// String pass = request.getParameter("pass");

		User user = new User();
		try {
			// request.getParameterMap():可以自动的获取form表单中的所有的标签的值.
			BeanUtils.populate(user, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		writer.write(user.getUsername() + ",你好.你的密码是:" + user.getPassword());
		System.out.println("name=" + user.getUsername() + ",pass=" + user.getPassword());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
