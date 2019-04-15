package com.syc.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {

	private Object object;
	public ProxyFactory(Object obj) {
		this.object=obj;
	}
	
	public Object newProxyInstance(){
		Class<? extends Object> clazz = object.getClass();
		
		return Proxy.newProxyInstance(clazz.getClassLoader(),
				clazz.getInterfaces(), new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

				//经纪人实现的功能
				System.out.println("经纪人,开始做准备工作...");
				
				//演戏的事情,演员去实现
				Object obj = method.invoke(object, args);
				
				System.out.println("经纪人,开始做善后工作...");
				
				return obj;
			}
		});
	}
}
