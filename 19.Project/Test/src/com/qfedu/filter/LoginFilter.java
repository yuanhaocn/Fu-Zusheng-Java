package com.qfedu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("*.jsp")
public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		// ��ȡsession����
		Object currentUser = req.getSession().getAttribute("currentUser");
		// �жϸö����Ƿ�Ϊ��
		if (currentUser == null) {
			req.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		chain.doFilter(req, resp);
	}
}