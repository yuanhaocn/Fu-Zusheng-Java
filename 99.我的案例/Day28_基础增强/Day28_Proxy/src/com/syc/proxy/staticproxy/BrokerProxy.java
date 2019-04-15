package com.syc.proxy.staticproxy;

/**
 * 经纪人,静态代理中的代理对象.
 * 
 * @类名称:BrokerProxy
 * @创建人:SYC
 * @创建时间:2017年8月2日 下午3:39:16
 */
public class BrokerProxy implements ISingStartPerform {

	private SingStar mStar;

	public BrokerProxy(SingStar star) {
		this.mStar = star;
	}

	@Override
	public void sing() {
		System.out.println("经纪人,为演唱会宣传造势....");
		
		//召唤歌星来唱歌
		mStar.sing();
		
		System.out.println("经纪人,为演唱会处理后事....");
	}

}
