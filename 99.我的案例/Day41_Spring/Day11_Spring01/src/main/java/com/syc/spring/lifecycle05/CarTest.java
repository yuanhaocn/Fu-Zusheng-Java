package com.syc.spring.lifecycle05;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CarTest {

	public static void main(String[] args) {
		// context:环境--->Spring容器环境.
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans05.xml");

		Car bean = context.getBean("car", Car.class);
		bean.move();

		context.close();
	}
}
