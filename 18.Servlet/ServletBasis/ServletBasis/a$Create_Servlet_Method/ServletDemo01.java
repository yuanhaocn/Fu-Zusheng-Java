package a$Create_Servlet_Method;

/**
 * 实现了Servlet接口，实现自己的服务器程序。此程序是搭载在tomcat服务软件上的“软件”，为用户提供公司的实现
 */
import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletDemo01 implements Servlet {

	@Override
	public void destroy() {
		// 是servlet对象销毁的手要执行的方法
		System.out.println("这个servlet要被销毁了。。。");
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// 是servlet对象被创建的时候执行的方法
		System.out.println("这servlet要被创建了。。。");
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// 服务方法，servlet的核心方法，提供服务的方法
		System.out.println("这个是核心servlet方法");
	}

}
