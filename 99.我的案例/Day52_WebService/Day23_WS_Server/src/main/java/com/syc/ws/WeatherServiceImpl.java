package com.syc.ws;

import javax.jws.WebService;

/*
 * 服务端的实现类,必须添加@WebService注解,此时变成了一个WebService服务类.
 * @BindingType:指定SOAP协议的版本号,默认是1.1的版本.如果用了1.2的版本,
 * 会导致无法在cmd命名行中使用wsimport命名.
 */
@WebService
//@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public class WeatherServiceImpl implements WeatherService {

	public String queryWeather(String city) {
		System.out.println("服务端接收到了通信请求....");
		return city + " 晴天";
	}

}
