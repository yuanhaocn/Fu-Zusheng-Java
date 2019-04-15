package com.syc.filter;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class DataFilter implements Filter {

	private List<String> dirtyWords = null;

	public void init(FilterConfig fConfig) throws ServletException {
		dirtyWords = new ArrayList<>();
		dirtyWords.add("tmd");
		dirtyWords.add("政府");
		dirtyWords.add("金三胖");
		dirtyWords.add("傻逼");
		dirtyWords.add("警察");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// 取出来request中的数据内容--->本来应该是request去取.
		// request此时不愿做这个事情--->request找一个自己的代理对象.
		// request.getParameter(name)

		HttpServletRequest req = (HttpServletRequest) request;
		
		// Java:虚拟机
		// Java:编写代码,.java--->编译代码.class--->(把不同的字节码交给虚拟机)执行代码
		// 谁把字节码给了虚拟机?--->ClassLoader类加载器把字节码给了虚拟机
		HttpServletRequest proxy = (HttpServletRequest) Proxy.newProxyInstance(
				request.getClass().getClassLoader(), 
				new Class[] { HttpServletRequest.class },
				new InvocationHandler() {
					// 调用
					// Person p=new Person();
					// Person --hello(msg);
					// Class clazz=p.getClass();
					// Method helloMethod=clazz.getDeclaredMethod("hello",
					// String.class);
					// helloMethod.invoke(p,args);

					// proxy:代理对象;method:要执行的方法;args:方法中可能存在的参数
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						//获取方法本身的名字
						String methodName = method.getName();
						if ("getParameter".equals(methodName)) {
							// 得到request对象中的数据
							String value = req.getParameter(args[0].toString());
							for (String data : dirtyWords) {
								if (value.contains(data)) {
									value = value.replace(data, "***");
								}
							}
							return value;
						} else {
							// 其他直接执行
							return method.invoke(req, args);
						}
					}
				});

		chain.doFilter(proxy, response);
	}

	public void destroy() {

	}

}