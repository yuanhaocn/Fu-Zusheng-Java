package com.syc.listener.scope;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//Implementations of this interface are notified of changes to 
//the list of active sessions in a web application.
//当这个web程序中session列表中的某个session发生了改变,这个监听就会发出响应的通知.
public class SessionListener implements HttpSessionListener {

	// 通知某个session创建了
	// HttpSessionEvent:代表了session是否改变的事件.
	//session会在第一次访问sevlet,jsp的时候,创建出来.
	//单纯的Servlet中不会自动创建session,需要调用request.getSession()方法才会创建session.
	//jsp中默认是开启了session功能的,也就是jsp会自动创建session.
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("session---create");
		//int age = (int) se.getSession().getAttribute("age");
		//System.out.println("age=" + age);
	}

	// 通知某个session被销毁了.
	//当调用session.invalidate()方法的时候,执行session的销毁方法.
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {

		int age = (int) se.getSession().getAttribute("age");
		System.out.println("age=" + age);

		System.out.println("session---destroy");
	}

}
