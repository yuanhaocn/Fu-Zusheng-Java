package com.syc.proxy.cglib02;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class DaoInterceptor implements MethodInterceptor {

	private Object target;
	private Transaction transaction;

	public DaoInterceptor(Object target, Transaction transaction) {
		this.target = target;
		this.transaction = transaction;
	}

	// 创建出来一个目标对象+代理对象的整合体对象---->子代理对象!
	public Object createProxy() {
		Enhancer hancer = new Enhancer();

		// 设置回调接口
		hancer.setCallback(this);
		
		Class<? extends Object> clazz = target.getClass();
		
		hancer.setClassLoader(clazz.getClassLoader());
		hancer.setInterfaces(clazz.getInterfaces());
		
		//指定子代理的父类!
		hancer.setSuperclass(clazz);

		//创建子代理对象
		return hancer.create();
	}

	// 接口中的回调方法
	public Object intercept(Object proxy, Method method, Object[] args, MethodProxy arg3) throws Throwable {

		String methodName = method.getName();

		if ("query".equals(methodName)) {
			method.invoke(target, args);
		} else {

			transaction.beginTransaction();

			method.invoke(target, args);

			transaction.commit();
		}

		return null;
	}

}
