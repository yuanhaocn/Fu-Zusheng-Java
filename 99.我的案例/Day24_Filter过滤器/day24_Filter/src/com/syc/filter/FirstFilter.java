package com.syc.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirstFilter implements Filter {

	public FirstFilter() {
		System.out.println("1.FirstFilter---构造方法.");
	}
	
	//Filter的生命周期方法:3个.

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("2.FirstFilter---init方法.");
	}

	//执行过滤的核心方法
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("3.FirstFilter---开始过滤.");
		
		//该方法可以拦截request是否能够到达Servlet
		chain.doFilter(request, response);
		
		System.out.println("5.FirstFilter---过滤完毕.");
	}

	
	public void destroy() {
		System.out.println("6.FirstFilter---销毁方法.");
	}

}