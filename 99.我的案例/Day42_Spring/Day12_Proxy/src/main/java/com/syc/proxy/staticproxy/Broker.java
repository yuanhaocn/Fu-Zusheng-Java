package com.syc.proxy.staticproxy;

public class Broker implements SingPerform {

	private SingStar star;

	public Broker(SingStar star) {
		this.star = star;
	}

	//将经纪人的活动与歌星的活动整合在一起.
	public void sing() {
		System.out.println("经纪人准备演唱会...");

		// 歌星:唱歌
		star.sing();

		System.out.println("经纪人为演唱会善后...");
	}

}
