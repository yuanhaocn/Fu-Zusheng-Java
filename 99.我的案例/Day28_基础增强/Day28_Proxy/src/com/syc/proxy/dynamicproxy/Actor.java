package com.syc.proxy.dynamicproxy;

/**
 * 演员类,动态代理中的目标类.
 * @类名称:Actor
 * @创建人:SYC
 * @创建时间:2017年8月2日 下午3:55:50
 */
public class Actor implements IActorPerform{

	@Override
	public void playAct() {
		System.out.println("演员开始演戏啦....");
	}

	@Override
	public void xidu() {
		System.out.println("演员开始吸毒啦....");
	}

}
