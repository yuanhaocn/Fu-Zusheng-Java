package com.syc.listener.scope;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//ServletContextListener:用来接收ServletContext变化的通知.
public class ApplicationListener implements ServletContextListener {

	//Notification that the web application initialization * process is starting. * 
	//All ServletContextListeners are notified of context * initialization 
	//before any filter or servlet in the web * application is initialized.
	//该方法通知ServletContext发生了变化,表明web进程开始执行了.
	//该方法的执行时机比所有的过滤器和servlet执行的都要早.
	//ServletContextEvent:代表ServletContext发生改变的事件.
	//当服务器启动的时候会执行一次.
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("application-init");
	}

	//该方法表明ServletContext要被销毁了.该方法是在所有的过滤器和servlet销毁之后来执行.
	//当该web项目从服务器移除的时候会执行一次.
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("application-destroy");
	}

}
