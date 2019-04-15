package com.syc.struts;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class MyInterceptor02 implements Interceptor {

	private static final long serialVersionUID = 1L;

	// 随着服务器的启动而执行,只会执行一次.
	// 通常在该方法中进行一些初始化的操作.
	public void init() {
		System.out.println("MyInterceptor02---->init()方法结束执行了...");
	}

	// 拦截方法.会执行N次.
	// 该方法可以决定后续的其他的拦截器以及Action能够执行.
	// ActionInvocation:包含了Action类的所有信息.
	// 返回值:该方法的返回值可能来自于两个地方:1.invocation.invoke()方法;2.来自于拦截器本身.
	public String intercept(ActionInvocation invocation) throws Exception {

		System.out.println("MyInterceptor02---->intercept()方法开始执行了...");

		// 该方法类似于过滤器的doFilter()方法.
		// 该方法相当于是一个"闸门",能够决定后续的拦截器以及Action是否能够执行.
		// invocation.invoke();
		String invoke = invocation.invoke();
		//invoke()方法的返回值就是Action类中要请求的方法的返回值!
		System.out.println("02---invoke="+invoke);

		System.out.println("MyInterceptor02---->intercept()方法结束执行了...");

		return invoke;
	}

	// 当服务器重启,停止的时候执行,也只会执行一次.
	// 通常在该方法中释放一些资源.
	public void destroy() {
		System.out.println("MyInterceptor02---->destroy()方法结束执行了...");
	}

}
