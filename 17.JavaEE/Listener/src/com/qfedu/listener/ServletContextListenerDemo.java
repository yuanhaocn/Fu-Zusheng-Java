package com.qfedu.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletContextListenerDemo implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("servletContext�����Ѿ���������");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("servletContext����ʼ��ʼ��");
	}

}
