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
 * 根据ID查找用户的Servlet.
 * 找到用户后,进行用户信息的修改.
 * @类名称:FindUserServlet
 * @创建人:SYC
 * @创建时间:2017年7月11日 下午5:21:20
 */
public class FindUserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		try {
			//获取用户id
			String id = request.getParameter("id");
			//根据id获取用户
			IUserService service=new UserServiceImpl();
			User user = service.findUser(id);
			request.setAttribute("modifyUser", user);
			//找到用户后,跳转到修改用户信息的jsp页面中
			request.getRequestDispatcher("/modifyuserinfo.jsp").forward(request, response);
		} catch (UserException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
