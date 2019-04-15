package com.syc.book.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syc.book.exception.UserException;
import com.syc.book.service.IUserService;
import com.syc.book.service.impl.UserServiceImpl;

/**
 * 实现用户激活功能.核心就是在dao中将state=0改为state=1.
 * @类名称:ActiveUserServlet
 * @创建人:SYC
 * @创建时间:2017年8月4日 下午3:41:39
 */
public class ActiveUserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取传递过来的激活码
		String activeCode = request.getParameter("activeCode");
		
		try {
			//必须有这个激活码对应的用户,才有必要进行激活.
			IUserService service=new UserServiceImpl();
			service.activeUser(activeCode);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		} catch (UserException e) {
			e.printStackTrace();
			response.getOutputStream().print(e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}