package com.syc.book.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.syc.book.domain.User;
import com.syc.book.exception.UserException;
import com.syc.book.service.IUserService;
import com.syc.book.service.impl.UserServiceImpl;

/**
 * 注册用户的Servlet
 * 
 * @类名称:RegisterServlet
 * @创建人:SYC
 * @创建时间:2017年8月4日 上午9:31:12
 */
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// String username = request.getParameter("username");

		// 验证码处理
		// 先获取用户输入的验证码--code;
		// 将这个code与session中存储的code进行对比.
		// 如果不一致,给用户界面上以提示,验证码错误!---返回注册页面.
		// return;

		String imageCode = request.getParameter("imageCode");
		// 获取session中存储的验证码
		String code = (String) request.getSession().getAttribute("imageCodeSession");
		if (!imageCode.equals(code)) {
			request.setAttribute("codeMsg", "验证码错误");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		}

		User user = new User();
		try {
			// 设置激活码
			user.setActiveCode(UUID.randomUUID().toString());
			user.setRole("普通用户");
			BeanUtils.populate(user, request.getParameterMap());
		} catch (InvocationTargetException | IllegalAccessException e) {
			e.printStackTrace();
			// 出异常的时候,设置异常提示信息
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}

		try {
			IUserService service = new UserServiceImpl();
			service.registerUser(user);
			// 注册成功
			request.getRequestDispatcher("/registerSuccess.jsp").forward(request, response);
		} catch (UserException e) {
			e.printStackTrace();
			// 注册失败的错误信息
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}