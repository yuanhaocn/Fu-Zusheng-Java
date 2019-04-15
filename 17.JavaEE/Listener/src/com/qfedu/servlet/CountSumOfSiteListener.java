package com.qfedu.servlet;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class CountSumOfSiteListener implements HttpSessionListener{
	int count = 0;

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		count++;
		System.out.println("��ǰ���������ǣ�" + count);
		//��ȡsession��id���ԺͿͻ��˵�ip��ַ
		HttpSession session = se.getSession();
		try {
			System.out.println(session.getId()+"____"+InetAddress.getLocalHost());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
 
	}
}
