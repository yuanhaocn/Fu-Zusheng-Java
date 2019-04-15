package com.qfedu.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletContextListenerDemo implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("servletContext对象已经被销毁了");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("servletContext对象开始初始化");
	}

}
