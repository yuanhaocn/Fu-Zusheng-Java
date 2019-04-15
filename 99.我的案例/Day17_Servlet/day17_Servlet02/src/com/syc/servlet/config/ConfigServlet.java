package com.syc.servlet.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * ServletConfig的作用
 */
public class ConfigServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// ServletConfig:是Tomcat服务器用来在初始化的时候,给Servlet传递信息用的.
	// ServletConfig能够传递什么信息?
	// ServletConfig怎么传递信息?
	// 后执行.程序员一般不要去复写该方法,可能会导致无参的init()方法不执行.
	@Override
	public void init(ServletConfig config) throws ServletException {

		// File file=new File("C://test.txt");

		// 根据key获取web.xml中,
		String path = config.getInitParameter("path");
		System.out.println(path);

		// Enumeration,集合
		// 获取所有的初始化参数
		Enumeration<String> names = config.getInitParameterNames();
		// 循环的判断条件
		while (names.hasMoreElements()) {
			// 取出下一个参数
			String name = names.nextElement();
			// 根据参数名获取参数值
			String paramValue = config.getInitParameter(name);
			System.out.println(paramValue);
			BufferedReader reader = null;
			try {
				reader = new BufferedReader(new FileReader(new File(paramValue)));
				String msg = null;
				while ((msg = reader.readLine()) != null) {
					System.out.println(msg);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
