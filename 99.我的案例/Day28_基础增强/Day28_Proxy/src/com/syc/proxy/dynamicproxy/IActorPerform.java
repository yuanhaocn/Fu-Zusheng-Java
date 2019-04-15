package com.syc.proxy.dynamicproxy;

/**
 * 动态代理的接口.该接口必须用由演员来实现,但是此时经纪人可以不实现该接口.
 * 动态代理特点:
 * 1.代理对象不需要实现接口,目标对象的功能无论怎么修改,不会影响代理对象;
 * 2.代理对象的创建,是由Java的JDK来创建的,该对象是在内存中动态生成的;
 * @类名称:IActorPerform
 * @创建人:SYC
 * @创建时间:2017年8月2日 下午3:54:31
 */
public interface IActorPerform {

	public void playAct();
	
	public void xidu();
}
