package com.syc.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;

public class DynamicTest {

	@Test
	public void dynamicTest(){
		
		Actor actor=new Actor();
		Class<? extends Actor> clazz = actor.getClass();
		
		//创建代理对象.
		IActorPerform proxy = (IActorPerform) Proxy.newProxyInstance(clazz.getClassLoader(), 
				clazz.getInterfaces(), new InvocationHandler() {
			
			//处理演戏事宜.
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				
				//经纪人实现的功能
				System.out.println("经纪人,接戏,接通告....");
				
				//演戏的事情,演员去实现
				Object obj = method.invoke(actor, args);
				
				System.out.println("经纪人,为新影片造势宣传...");
				
				return obj;
			}
		});
		
		//由代理对象去实现演戏这个任务.
		proxy.playAct();
	}
	
	@Test
	public void proxyTest(){
		Actor actor=new Actor();
		//SingStar=new SingStar();
		ProxyFactory factory=new ProxyFactory(actor);
		IActorPerform proxy=(IActorPerform) factory.newProxyInstance();
		proxy.playAct();
	}
}
