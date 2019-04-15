package com.syc.listener.scope;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

//A request is defined as coming into scope 
//when it is about to enter the first servlet or filter in each web application,
//as going out of scope when it exits the last servlet or the first filter in the chain.
//ServletRequestListener这个监听器就是用来监听request对象什么时候进入了request域,以及什么时候销毁了该域.
//只要对该项目,发起了任意的一个请求,无论请求的是哪个资源,都会触发该监听.
public class RequestListener implements ServletRequestListener {

	// 监听request域的创建
	// Events of this kind indicate lifecycle events for a ServletRequest.
	// ServletRequestEvent代表了ServletRequest的生命周期事件.
	// The source of the event is the ServletContext of this web application.
	// 该事件来自于ServletContext(application).
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("request-init");
		//ServletContext servletContext = sre.getServletContext();
		//此时得不到request的属性值
		String name = (String) sre.getServletRequest().getAttribute("name");
		//source=org.apache.catalina.core.ApplicationContextFacade
		Object source = sre.getSource();
		System.out.println("init-name="+name);
		System.out.println("source="+source);
	}

	// 监听request域的销毁
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		//此时可以得到request的属性值
		String name = (String) sre.getServletRequest().getAttribute("name");
		System.out.println("destory-name="+name);
		System.out.println("request-destroy");
	}

}
