package com.syc.bookstore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syc.bookstore.domain.User;
import com.syc.bookstore.exception.UserException;
import com.syc.bookstore.service.IUserService;
import com.syc.bookstore.service.impl.UserServiceImpl;

/**
 * 登陆Servlet
 * 
 * @类名称:LoginServlet
 * @创建人:SYC
 * @创建时间:2017年7月9日 下午5:36:18
 */
public class LoginServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.doGet(request, response);

		// 获取用户名密码登陆信息
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		try {
			IUserService service = new UserServiceImpl();
			User user = service.login(username, password);

			// 一般情况下,登陆成功后跳转到index.jsp中
			String path = "/index.jsp";
			// System.out.println(user.getRole());
			if ("admin".equals(user.getRole())) {
				// 如果是管理员角色,则跳转到管理员页面
				path = "/admin/login/home.jsp";
			}
			// 将user信息保存到session中
			request.getSession().setAttribute("user", user);
			request.getRequestDispatcher(path).forward(request, response);
		} catch (UserException e) {
			e.printStackTrace();
			// 显示异常信息
			request.setAttribute("loginMsg", e.getMessage());
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
