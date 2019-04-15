package com.syc.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		System.out.println("拦截器...");

		String uri = request.getRequestURI();
		if (uri.indexOf("login.action") > 0) {
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			if (user == null) {
				System.out.println("user....");
				// 如果之前登陆过,也直接放行
				return true;
			}else{
				String name = user.getUsername();
				if(name==null){
					response.sendRedirect(request.getContextPath() + "/login.jsp");
					return false;
				}
			}

			// 如果是登陆请求,则直接放行
			return false;
		}

		// 其他情况,认为没有登陆
		// 请求转发:
		// request.getRequestDispatcher("/login.jsp").forward(request,
		// response);

		// 重定向:
		response.sendRedirect(request.getContextPath() + "/login.jsp");

		return false;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
