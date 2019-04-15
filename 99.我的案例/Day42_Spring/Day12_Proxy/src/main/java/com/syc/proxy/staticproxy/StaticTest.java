package com.syc.proxy.staticproxy;

public class StaticTest {

	public static void main(String[] args) {
		SingStar star = new SingStar();
		Broker broker = new Broker(star);
		broker.sing();
	}
}
