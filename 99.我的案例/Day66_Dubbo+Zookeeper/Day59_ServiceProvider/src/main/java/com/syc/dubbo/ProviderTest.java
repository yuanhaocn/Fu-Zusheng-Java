package com.syc.dubbo;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProviderTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring-dubboprovider.xml");
		
		context.start();
		
		//模拟时刻在线状态
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		context.close();
	}
}
