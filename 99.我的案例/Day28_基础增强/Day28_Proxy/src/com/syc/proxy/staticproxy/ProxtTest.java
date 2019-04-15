package com.syc.proxy.staticproxy;

import org.junit.Test;

public class ProxtTest {

	@Test
	public void proxyTest(){
		SingStar star=new SingStar();
		BrokerProxy proxy=new BrokerProxy(star);
		//经纪人负责演唱会事宜!
		proxy.sing();
	}
}
