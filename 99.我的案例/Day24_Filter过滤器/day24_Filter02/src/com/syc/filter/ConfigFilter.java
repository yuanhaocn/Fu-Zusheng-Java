package com.syc.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ConfigFilter implements Filter {

	// 初始化Filter的方法,只会执行一次 .
	// FilterConfig:获取配置信息.
	public void init(FilterConfig config) throws ServletException {
		String filterName = config.getFilterName();
		System.out.println("filterName=" + filterName);

		// 获取Filter的所有的配置参数名称
		Enumeration<String> names = config.getInitParameterNames();
		while (names.hasMoreElements()) {
			// 获取参数名称
			String paramName = names.nextElement();
			// 根据参数名称获取初始参数的值
			String value = config.getInitParameter(paramName);
			System.out.println(paramName + "---" + value);
		}
	}

	// doFilter()执行过滤的方法,过滤器中最核心的方法.
	// 该方法会执行多次,每请求一次满足过滤规则的资源的时候,就会执行一次.
	// FilterChain:过滤链.
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// chain.doFilter()可以决定Servlet的service()是否能够被执行.
		// chain.doFilter()可以决定请求目标资源的service()是否能够被执行.
		// 如果把chain.doFilter()给去掉,就可以阻止Servlet的service()方法的执行.

		// 可以在doFilter()把request传递给service之前,修改request对象里的数据;

		chain.doFilter(request, response);

		// 可以在这里,拿到service()方法返回来的response对象,将response对象进行修改.

	}

	//用来释放过滤器中的资源,只会执行一次.
	public void destroy() {

	}

}