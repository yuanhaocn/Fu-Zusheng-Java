package com.syc.spring.annotation01;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnoationTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("beans01.xml");
		
		UserAction action = context.getBean("web",UserAction.class);
		action.register();
		
		context.close();
	}
}
