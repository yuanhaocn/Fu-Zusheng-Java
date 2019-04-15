package com.syc.book.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.syc.book.domain.User;
import com.syc.book.exception.UserException;
import com.syc.book.service.impl.UserServiceImpl;
import com.syc.book.service.IUserService;

/**
 * 修改用户信息的Servlet
 * 
 * @类名称:ModifyUserServlet
 * @创建人:SYC
 * @创建时间:2017年8月4日 下午4:16:22
 */
public class ModifyUserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			User user = new User();
			BeanUtils.populate(user, request.getParameterMap());

			// 修改用户信息
			IUserService service = new UserServiceImpl();
			service.modifyUser(user);
			//销毁session对象
			request.getSession().invalidate();
			request.getRequestDispatcher("/modifyUserInfoSuccess.jsp").forward(request, response);
		} catch (IllegalAccessException | InvocationTargetException | UserException e) {
			e.printStackTrace();
			request.getRequestDispatcher("/modifyUserInfo.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}