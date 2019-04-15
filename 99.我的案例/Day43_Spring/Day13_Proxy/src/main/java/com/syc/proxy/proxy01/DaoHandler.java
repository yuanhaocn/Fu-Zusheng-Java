package com.syc.proxy.proxy01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/*
 * 处理器,负责将目标对象和代理对象整合在一起
 */
public class DaoHandler implements InvocationHandler {

	private Object target;
	private Transaction transaction;

	public DaoHandler(Object object, Transaction transaction) {
		this.target = object;
		this.transaction = transaction;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		// 获取方法名
		String methodName = method.getName();

		if ("query".equals(methodName)) {
			method.invoke(target, args);
		} else {
			// 开启事务
			transaction.beginTransaction();

			// 执行目标方法
			method.invoke(target, args);

			// 提交事务
			transaction.commit();
		}

		return null;
	}

}
