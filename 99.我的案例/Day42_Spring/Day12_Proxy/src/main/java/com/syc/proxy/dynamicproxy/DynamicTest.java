package com.syc.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;

public class DynamicTest {

	public static void main(String[] args) {

		// 获取目标类的字节码
		final SingStar target = new SingStar();
		Class<? extends SingStar> clazz = target.getClass();

		// perform=目标对象+代理对象!
		//注意:此处必须被强转成父接口类型!
		SingPerform perform=(SingPerform) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(),
				new InvocationHandler() {
					// 调用,处理---->"演唱会"
					// proxy:代理对象;
					// method:要执行的目标方法---->sing();
					// args:要执行的目标方法中的参数---->sing()方法中的参数.
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

						// proxy.xxx();
						System.out.println("经纪人准备演唱会...");

						// 利用反射执行目标方法.
						Object obj = method.invoke(target, args);

						// proxy.xxx();
						System.out.println("经纪人为演唱会善后...");

						return obj;
					}
				});

		//利用代理对象,调用要执行的方法.
		perform.sing();
	}
	
	@Test
	public void dynamicTest(){
		SingStar target=new SingStar();
		Broker broker=new Broker();
		ProxyFactory factory=new ProxyFactory(target, broker);
		//obj=target对象+proxy对象
		SingPerform perform = (SingPerform) factory.newProxyInstance();
		perform.sing();
	}
}
