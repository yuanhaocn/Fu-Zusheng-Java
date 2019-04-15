package com.syc.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {

	private Object target;
	private Broker broker;

	public ProxyFactory(Object target, Broker broker) {
		this.target = target;
		this.broker = broker;
	}

	public Object newProxyInstance() {

		Class<? extends Object> clazz = target.getClass();

		return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), new InvocationHandler() {
			// 调用,处理---->"演唱会"
			// proxy:代理对象;
			// method:要执行的目标方法---->sing();
			// args:要执行的目标方法中的参数---->sing()方法中的参数.
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

				broker.prepareSing();
				// System.out.println("经纪人准备演唱会...");

				// 利用反射执行目标方法.
				Object obj = method.invoke(target, args);

				broker.afterSing();
				// System.out.println("经纪人为演唱会善后...");

				return obj;
			}
		});
	}
}
