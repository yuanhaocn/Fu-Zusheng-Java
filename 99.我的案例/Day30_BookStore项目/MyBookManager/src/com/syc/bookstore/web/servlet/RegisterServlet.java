package com.syc.bookstore.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.syc.bookstore.domain.User;
import com.syc.bookstore.exception.UserException;
import com.syc.bookstore.service.IUserService;
import com.syc.bookstore.service.impl.UserServiceImpl;

/**
 * 用户注册的Servlet
 * 
 * @类名称:RegisterServlet
 * @创建人:SYC
 * @创建时间:2017年7月1日 下午11:14:29
 */
public class RegisterServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		super.doGet(request, response);

		// 检验验证码是否正确
		String imageCode = request.getParameter("imageCode");
		// 取出session中的验证码内容
		String codeSession = (String) request.getSession().getAttribute("imageCodeSession");
		// 如果输入的验证码与session中的验证码不同,则返回到注册页面
		if (!imageCode.equals(codeSession)) {
			request.setAttribute("codemsg", "验证码错误!");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		}

		User user = new User();
		try {
			// 设置激活码
			user.setActiveCode(UUID.randomUUID().toString());
			// 将request请求中的key-value键值对信息封装到User对象中
			BeanUtils.populate(user, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
		}

		try {
			// 调用service层的注册方法
			IUserService service = new UserServiceImpl();
			service.registerUser(user);
			// 注册成功后,将user保存到session中
			// request.getSession().setAttribute("user", user);
			// 跳转到注册成功页面
			request.getRequestDispatcher("/registersuccess.jsp").forward(request, response);
		} catch (UserException e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
