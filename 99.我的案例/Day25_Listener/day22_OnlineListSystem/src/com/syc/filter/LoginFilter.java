package com.syc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 过滤登陆信息:
 * http://localhost:8080/day21_filter04/login 可以直接访问
 * http://localhost:8080/day21_filter04/login.jsp 可以直接访问
 * http://localhost:8080/day21_filter04/show 不能直接访问
 * http://localhost:8080/day21_filter04/show.jsp 不能直接访问
 * 
 * @author 一一哥
 * @Description:
 */
public class LoginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	/**
	 * 
	 1. 先指定放行的资源，哪些资源不需要拦截： login.jsp + /login (request对象可以获取) 2.
	 * 获取session，从session中获取登陆用户 3. 判断是否为空： 为空， 说明没有登陆， 跳转到登陆 不为空， 已经登陆，放行！
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		
		// 0. 转换
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		// 1. 获取请求资源，截取
		String uri = request.getRequestURI(); // /emp_sys/login.jsp
		// 截取 【login.jsp或login】
		String requestPath = uri.substring(uri.lastIndexOf("/") + 1,
				uri.length());

		// 2. 判断： 先放行一些资源：/login.jsp、/login
		if ("login".equals(requestPath) || "login.jsp".equals(requestPath)) {
			// 放行
			chain.doFilter(request, response);
		} else {
			// 3. 对其他资源进行拦截
			// 3.1 先获取Session、获取session中的登陆用户(loginInfo)
			HttpSession session = request.getSession(false);
			// 判断
			if (session != null) {

				Object obj = session.getAttribute("loginUser");

				// 3.2如果获取的内容不为空，说明已经登陆，放行
				if (obj != null) {
					// 放行
					chain.doFilter(request, response);
					//注意:此处必须return,否则会造成异常:
					//Cannot forward after response has been committed!
					return;
				} else {
					// 3.3如果获取的内容为空，说明没有登陆； 跳转到登陆
					uri = "/login.jsp";
				}

			} else {
				// 肯定没有登陆
				uri = "/login.jsp";
			}
			
			//此处的有问题?
			request.getRequestDispatcher(uri).forward(request, response);
			//response.sendRedirect(request.getContextPath()+uri);
		}

		/*
		 * // 设置编码 req.setCharacterEncoding("UTF-8");
		 * response.setCharacterEncoding("UTF-8");
		 * response.setContentType("text/html;UTF-8");
		 * 
		 * // 对登陆进行过滤 HttpServletRequest req = (HttpServletRequest) req; //
		 * 获取请求uri String uri = req.getRequestURI(); // 截取出url中最后一个/后面的部分 String
		 * substring = uri .substring(uri.lastIndexOf("/") + 1, uri.length());
		 * if ("login".equals(substring) || "login.jsp".equals(substring)) { //
		 * 可以登陆,过滤器放行 chain.doFilter(req, response); } else { // 对其他资源进行拦截 //
		 * 3.1 先获取Session、获取session中的登陆用户(loginMsg): HttpSession session =
		 * req.getSession(false); if (session != null) { Object obj =
		 * session.getAttribute("loginMsg"); if (obj != null) { //
		 * 3.2如果获取的内容不为空，说明已经登陆，放行 chain.doFilter(req, response); } else { //
		 * 3.3如果获取的内容为空，说明没有登陆； 跳转到登陆 uri = "/login.jsp"; } } else { // 肯定没有登陆过
		 * uri = "/login.jsp"; }
		 * 
		 * req.getRequestDispatcher(uri).forward(req, response); }
		 */
	}

	@Override
	public void destroy() {

	}

}
