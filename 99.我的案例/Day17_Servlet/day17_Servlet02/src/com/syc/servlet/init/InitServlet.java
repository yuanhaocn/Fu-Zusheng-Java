package com.syc.servlet.init;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 2个init()的区别.
 * 
 * @类名称:InitServlet
 * @创建人:SYC
 * @创建时间:2017年7月18日 上午11:21:20
 */
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public InitServlet() {
		System.out.println("1.构造方法执行了...");
	}

	//先执行
	@Override
	public void init() throws ServletException {
		System.out.println("2.init方法执行了...");
	}
	
	//ServletConfig:是Tomcat服务器用来在初始化的时候,给Servlet传递信息用的.
	//ServletConfig能够传递什么信息?
	//ServletConfig怎么传递信息?
	//后执行.程序员一般不要去复写该方法,可能会导致无参的init()方法不执行.
	@Override
	public void init(ServletConfig config) throws ServletException {
		//该方法的内部实现是:this.config = config;this.init();
		super.init(config);
		System.out.println("3.init(config)方法执行了...");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.service(req, resp);
		System.out.println("4.service方法执行了...");
	}

	@Override
	public void destroy() {
		System.out.println("5.destroy()方法执行了...");
	}

}
