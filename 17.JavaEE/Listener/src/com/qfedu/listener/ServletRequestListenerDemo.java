package com.qfedu.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class ServletRequestListenerDemo implements ServletRequestListener{

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
	System.out.println("request被销毁");
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
	System.out.println("request被创建");
	}

}
