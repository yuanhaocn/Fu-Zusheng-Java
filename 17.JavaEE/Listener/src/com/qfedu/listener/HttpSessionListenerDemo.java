package com.qfedu.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
public class HttpSessionListenerDemo implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent se) {
	System.out.println("session被创建。。。。");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("session 被销毁");
	}

}
