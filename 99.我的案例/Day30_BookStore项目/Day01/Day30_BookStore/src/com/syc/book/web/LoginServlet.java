package com.syc.book.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syc.book.domain.User;
import com.syc.book.exception.UserException;
import com.syc.book.service.IUserService;
import com.syc.book.service.impl.UserServiceImpl;

/**
 * 登陆的Servlet
 * @类名称:LoginServlet
 * @创建人:SYC
 * @创建时间:2017年8月4日 上午11:56:07
 */
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		try {
			//进行登陆验证
			IUserService service=new UserServiceImpl();
			User user = service.login(username, password);
			
			//默认的跳转页面
			String path="/index.jsp";
			
			//判断是否是管理员
			if("admin".equals(user.getRole())){
				path="/admin/login/home.jsp";
			}
			
			//利用session保存用户的登陆信息
			request.getSession().setAttribute("user", user);
			request.getRequestDispatcher(path).forward(request, response);
		} catch (UserException e) {
			e.printStackTrace();
			//处理登陆失败时的信息
			request.setAttribute("loginMsg", e.getMessage());
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}