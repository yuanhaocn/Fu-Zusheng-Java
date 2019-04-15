package com.qfedu.servlet;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class CountNumberOfSiteListener implements HttpSessionListener {
	int count = 0;

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		count++;
		System.out.println("��ǰ���������ǣ�" + count);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		//session������������Ϊ
		HttpSession session = se.getSession();
		session.setMaxInactiveInterval(10);
		count--;
		System.out.println("��ǰ���������ǣ�"+count);
	}

}
