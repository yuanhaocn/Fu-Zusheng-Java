package com.syc.servlet.lifeCycle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LifeCycleServlet() {
		System.out.println("构造方法执行了...");
	}

	// Servlet中与生命周期相关的方法,一共有3个.

	// 该方法只会执行一次.该方法用来进行初始化,也就是在Servlet第一次用来进行实例化配置的时候才会执行.
	// 通常在该方法进行一些加载或者初始化一些东西.
	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("init方法执行了...");
	}

	/*
	 * @Override public void init(ServletConfig config) throws ServletException
	 * { super.init(config);
	 * 
	 * }
	 */

	// 该方法是复写次数最多的方法.
	// 每访问一次,就会执行一次该方法.
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.service(req, resp);
		System.out.println("service方法执行了...");
	}

	// 销毁的方法,该方法也只能执行一次.通常在该方法中用来释放资源.比如IO流关闭,数据库资源要Close().
	//关闭服务器或者Servlet被停止掉了的时候,会调用.
	@Override
	public void destroy() {
		super.destroy();
		System.out.println("destroy方法执行了...");
	}
}
