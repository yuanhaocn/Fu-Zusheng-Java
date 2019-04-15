package com.syc.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.syc.entity.Admin;
import com.syc.service.IAdminService;
import com.syc.service.impl.AdminService;

/**
 * 处理登陆和退出的Servlet
 * 
 * @author 一一哥
 * @Description:
 */
public final class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 7799715110182988179L;

	private IAdminService<Admin> mService = new AdminService();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 判断是登陆还是退出:
		String method = request.getParameter("method");

		if ("login".equals(method)) {
			login(request, response);
		} else if ("out".equals(method)) {
			logout(request, response);
		}

	}

	// 登陆方法.在该方法中要将登陆的用户保存到session中.
	@SuppressWarnings("unchecked")
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = null;
		try {
			// 获取参数值
			// String name = request.getParameter("name");
			// String pass = request.getParameter("pass");
			Admin adminUser = new Admin();
			// common-bean-util工具类封装bean
			// BeanUtils.copyProperty(admin, "name", name);
			// BeanUtils.copyProperty(admin, "pass", pass);

			BeanUtils.populate(adminUser, request.getParameterMap());

			// 调用service层的login()方法.
			Admin admin = mService.login(adminUser);

			if (admin != null) {
				// 1.登陆成功后,将该用户保存到session中.
				request.getSession().setAttribute("loginUser", admin);

				// 2.[在线列表]:
				// ①.先从servletContext中拿到在线列表集合,onLineList;
				// ②.将当前用户放入"在线列表"集合中.
				ServletContext context = getServletContext();
				// List<Admin> onLineList = (List<Admin>)
				// context.getAttribute("onLineList");
				CopyOnWriteArrayList<Admin> onLineList = (CopyOnWriteArrayList<Admin>) context
						.getAttribute("onLineList");

				if (onLineList != null) {
					List<Integer> ids=new ArrayList<Integer>();
					if (onLineList.size() == 0) {
						onLineList.add(admin);
						ids.add(admin.getId());
					} else {
						for (int i = 0; i < onLineList.size(); i++) {
							Admin admin2 = onLineList.get(i);
							ids.add(admin2.getId());
							if (!ids.contains(admin.getId())) {
								onLineList.add(admin);
								ids.add(admin.getId());
								break;
							}
						}
					}
				}

				// 3.存在该用户,则进行登陆.
				url = "/show";
			} else {
				// 不存在该用户,不能进行登陆,跳转到登陆界面
				url = "/login.jsp";
			}
		} catch (IllegalAccessException e) {// 发生异常,跳转到异常处理界面
			e.printStackTrace();
			url = "/error/error.jsp";
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			url = "/error/error.jsp";
		}

		// 转发
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 退出的方法:就是销毁session里的本对象.
	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 先获取session对象
		HttpSession session = request.getSession(false);
		// Object obj = session.getAttribute("loginUser");
		if (session != null) {
			// 从session中移除用户
			session.removeAttribute("loginUser");
			// session失效
			session.invalidate();
		}
		// 进行重定向,不需要传值.
		response.sendRedirect(request.getContextPath() + "/login.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}

}
