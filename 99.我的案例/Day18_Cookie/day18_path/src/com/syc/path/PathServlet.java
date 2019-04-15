package com.syc.path;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PathServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");

		//Servlet里,可以像普通的Java类一样,去通过类名.class.getResourceAsStream("/xxx")去加载某个资源文件.
		//注意:getResourceAsStream("/xxx")只能去拿src目录下的资源,而不能获取WebContent或者WebRoot目录下的资源.
		// src的符号是/
		//InputStream is = PathServlet.class.getResourceAsStream("/user.properties");
		
		//Servlet上下文---Tomcat服务器的环境.
		//ServletContext.getResourceAsStream("/xxx")可以获取WebContent或者WebRoot目录下的资源.
		//此时的/代表的WebContent或者是WebRoot目录,不再代表src目录了.
		ServletContext context = getServletContext();
		//InputStream is = context.getResourceAsStream("/user.properties");
		InputStream is = context.getResourceAsStream("/WEB-INF/user.properties");
		//getServletContext().getResourceAsStream("/xxx");
		
		//获取资源所在的绝对路径
		String realPath = getServletContext().getRealPath("/WEB-INF/user.properties");
		//C:\NewJava\.metadata\.plugins\org.eclipse.wst.server.core\tmp2\wtpwebapps\day18_path\WEB-INF/user.properties
		System.out.println("真实路径="+realPath);
		
		Properties props = new Properties();
		//空指针原因:对象为空.
		props.load(is);

		String name = props.getProperty("username");
		String pass = props.getProperty("password");

		response.getWriter().write("姓名:" + name + ",密码:" + pass);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
