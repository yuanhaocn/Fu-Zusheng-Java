package com.syc.proxy.dynamicproxy;

/*
 * 目标类
 */
public class SingStar implements SingPerform {

	/*
	 * 目标方法
	 */
	public void sing() {
		System.out.println("歌星唱歌...");
	}

}
