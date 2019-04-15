package com.syc.proxy.dynamicproxy;

/**
 * 动态代理特点:
 * 动态代理中,目标类和代理类不需要实现同一个接口!
 * 优点:
 * 1.此时因为代理对象不需要实现目标对象的接口,所以目标对象的接口无论怎么扩展,都不会影响到代理对象!
 * 2.Proxy.newProxyInstance()方法创建的对象,是具有目标类和代理类共同功能的对象!
 * 缺点:
 * 实现和理解起来稍微有点难度!
 */
public interface SingPerform {

	//演唱会
	public void sing();
	
}
