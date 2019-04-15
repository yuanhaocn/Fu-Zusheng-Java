package com.syc.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.syc.ssm.domain.User;

public class UserInterceptor implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		System.out.println("拦截器开始工作...");
		
		String uri = request.getRequestURI();
		if (uri.indexOf("login.action") > 0 || uri.indexOf("register.action") > 0) {
			System.out.println("login or register....");
			return true;
		}
		
		User user=(User) request.getSession().getAttribute("user");
		if(user!=null){
			return true;
		}
		
		//重新登陆
		response.sendRedirect(request.getContextPath()+"/login.jsp");

		return false;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
