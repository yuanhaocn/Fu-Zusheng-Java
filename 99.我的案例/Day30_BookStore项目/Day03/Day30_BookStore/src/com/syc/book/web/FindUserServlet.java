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
 * 根据id查找User
 * 
 * @类名称:FindUserServlet
 * @创建人:SYC
 * @创建时间:2017年8月4日 下午4:04:00
 */
public class FindUserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String id = request.getParameter("id");
			IUserService service = new UserServiceImpl();
			// 查找要修改信息的User对象
			User user = service.findUser(id);
			request.setAttribute("modifyUser", user);
			request.getRequestDispatcher("/modifyUserInfo.jsp").forward(request, response);
		} catch (UserException e) {
			e.printStackTrace();
			request.getRequestDispatcher("/myAccount.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}