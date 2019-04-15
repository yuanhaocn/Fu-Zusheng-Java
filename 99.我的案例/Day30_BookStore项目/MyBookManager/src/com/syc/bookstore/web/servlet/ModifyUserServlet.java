package com.syc.bookstore.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.syc.bookstore.domain.User;
import com.syc.bookstore.exception.UserException;
import com.syc.bookstore.service.IUserService;
import com.syc.bookstore.service.impl.UserServiceImpl;

/**
 * 修改用户信息的Servlet
 * 
 * @类名称:ModifyUserServlet
 * @创建人:SYC
 * @创建时间:2017年7月11日 下午5:37:08
 */
public class ModifyUserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		super.doGet(request, response);

		try {
			// 创建一个新用户,封装修改后的数据.
			User user = new User();
			// 将request请求中的参数值封装到user对象中.
			BeanUtils.populate(user, request.getParameterMap());
			// 修改用户信息
			IUserService service = new UserServiceImpl();
			service.modifyUser(user);

			// 修改成功后,让当前用户的Session信息失效,以便重新登录.
			request.getSession().invalidate();
			//跳转到修改成功页面
			request.getRequestDispatcher("/modifyUserInfoSuccess.jsp").forward(request, response);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		} catch (UserException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
