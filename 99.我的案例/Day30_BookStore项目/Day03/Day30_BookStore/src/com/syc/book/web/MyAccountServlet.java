package com.syc.book.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syc.book.domain.User;

/**
 * 我的账户:如果用户没有登陆,跳转到login.jsp;
 * 如果用户已经登陆:显示用户账户信息.
 * @类名称:MyAccountServlet
 * @创建人:SYC
 * @创建时间:2017年8月4日 下午2:11:38
 */
public class MyAccountServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//从session中获取User对象
		User user = (User) request.getSession().getAttribute("user");
		if(user==null){
			//该用户未登录
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		}else{
			String path="/myAccount.jsp";
			
			//如果是管理员用户
			if("admin".equals(user.getRole())){
				path="/admin/login/home.jsp";
			}
			
			request.getRequestDispatcher(path).forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}