package com.syc.layer.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.syc.layer.domain.User;
import com.syc.layer.service.ILoginService;
import com.syc.layer.service.impl.LoginServiceImpl;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			User user = new User();
			BeanUtils.populate(user, request.getParameterMap());
			ILoginService service = new LoginServiceImpl();
			User loginUser = service.login(user);

			if (loginUser == null) {
				//跳转到登陆页面
				response.sendRedirect(request.getContextPath() + "/login.jsp");
			} else {
				//为该用户创建一个session对象
				request.getSession().setAttribute("user", loginUser);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}

		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}