package com.syc.spring.annotation02;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans02.xml");

		Car car = context.getBean("car", Car.class);
		String logo = car.getCar().getLogo();
		System.out.println("logo=" + logo);

		context.close();
	}
}
