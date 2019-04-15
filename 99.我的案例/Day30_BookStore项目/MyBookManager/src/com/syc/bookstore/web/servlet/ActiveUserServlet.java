package com.syc.bookstore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syc.bookstore.exception.UserException;
import com.syc.bookstore.service.IUserService;
import com.syc.bookstore.service.impl.UserServiceImpl;

/**
 * 邮件发送成功后,激活用户
 * 
 * @类名称:ActiveUserServlet
 * @创建人:SYC
 * @创建时间:2017年7月9日 下午9:20:38
 */
public class ActiveUserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.doGet(request, response);

		try {
			// 获取激活码
			String activeCode = request.getParameter("activeCode");
			// 激活用户
			IUserService service = new UserServiceImpl();
			service.activeUser(activeCode);
			// 激活成功后,跳转到登陆界面
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		} catch (UserException e) {
			e.printStackTrace();
			// 输出错误信息
			response.getOutputStream().println(e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
