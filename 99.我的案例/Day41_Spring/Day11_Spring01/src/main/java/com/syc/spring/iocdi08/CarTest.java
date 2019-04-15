package com.syc.spring.iocdi08;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CarTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans08.xml");

		CarFactory factory = context.getBean("factory", CarFactory.class);

		factory.showLogo();
		
		factory.move();
		
		context.close();
	}
}
