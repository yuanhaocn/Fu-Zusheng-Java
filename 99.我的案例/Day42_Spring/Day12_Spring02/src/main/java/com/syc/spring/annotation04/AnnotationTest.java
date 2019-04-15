package com.syc.spring.annotation04;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans04.xml");

		CarFactory factory = context.getBean("factory", CarFactory.class);
		factory.showLogo();
		factory.move();
		
		context.close();
	}
}
