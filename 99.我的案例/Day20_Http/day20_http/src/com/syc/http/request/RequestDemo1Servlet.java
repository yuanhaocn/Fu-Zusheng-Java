package com.syc.http.request;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestDemo1Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		// requestLine(request);

		// 获取请求参数的方法:
		// 1.第一种:最常用的方式.
		String name = request.getParameter("name");

		// 2.第二种:获取表单中所有的请求参数.
		// Map<String, String[]> map = request.getParameterMap();

		// 3.第三种:获取查询字符串.只对get请求有效.(很少用)
		// String str = request.getQueryString();
		// System.out.println("查询字符串="+str);

		// 4.第四种:针对不知道请求参数的name的情况.
		Enumeration<String> parameterNames = request.getParameterNames();
		while (parameterNames.hasMoreElements()) {
			// 获取每一个请求参数中的name.
			String paramName = parameterNames.nextElement();
			// 根据key获取单个的值
			String value = request.getParameter(paramName);
			//对乱码的中文重新编码.针对post请求处理中文乱码问题.get不会乱码.(针对jdk1.7以上的版本)
			value=new String(value.getBytes("iso-8859-1"),"utf-8");
			// 根据key获取多个值
			if("hobit".equals(paramName)){
				String[] parameterValues = request.getParameterValues(paramName);
				for(int i=0;i<parameterValues.length;i++){
					String love=new String(parameterValues[i].getBytes("iso-8859-1"),"utf-8");
					System.out.println("爱好:"+love);
				}
			}
			System.out.println("Value=" + value);
		}
	}

	private void requestLine(HttpServletRequest request) {
		// 获取请求的方法名称
		String method = request.getMethod();
		System.out.println("method=" + method);
		// 获取url地址的path路径部分
		String requestURI = request.getRequestURI();
		// 获取请求的url地址
		String requestURL = request.getRequestURL().toString();
		// 获取请求协议
		String protocol = request.getProtocol();

		System.out.println("URI=" + requestURI + ",URL=" + requestURL + ",Pro=" + protocol);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}