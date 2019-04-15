package com.syc.spring.construct09;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CarTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans09.xml");

		Car car = context.getBean("car", Car.class);
		String name = car.getName();
		String logo = car.getAudi().getLogo();
		System.out.println("name=" + name + ",logo=" + logo);

		context.close();
	}
}
