package com.syc.ws.wstest;

import com.syc.ws.client01.WeatherServiceImpl;
import com.syc.ws.client01.WeatherServiceImplService;

public class WeatherTest01 {

	@SuppressWarnings("restriction")
	public static void main(String[] args) {
		//创建服务视图
		WeatherServiceImplService service=new WeatherServiceImplService();
		//调用服务端提供的方法进行服务调用
		WeatherServiceImpl impl = service.getPort(WeatherServiceImpl.class);
		String msg = impl.queryWeather("上海");
		System.out.println("msg="+msg);
	}
}
