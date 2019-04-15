package com.syc.ws;

import javax.xml.ws.Endpoint;

/*
 * 用来发布WebService的服务.
 */
public class WeatherServicePublisher {

	public static void main(String[] args) {
		// address:服务被发布到的地址;
		// 第二个参数:要被发布的服务
		Endpoint.publish("http://127.0.0.1:10001/weather", new WeatherServiceImpl());
	}

}
