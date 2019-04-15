package com.syc.proxy.staticproxy;

/**
 * 明星类,静态代理中的被代理对象,也就是我们的目标对象.
 * 该类要实现sing()方法.
 * @类名称:SingStar
 * @创建人:SYC
 * @创建时间:2017年8月2日 下午3:37:00
 */
public class SingStar implements ISingStartPerform{

	@Override
	public void sing() {
		System.out.println("大明星开唱啦.....");
	}

}
