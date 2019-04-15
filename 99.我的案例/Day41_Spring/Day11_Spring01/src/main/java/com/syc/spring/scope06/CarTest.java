package com.syc.spring.scope06;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CarTest {

	public static void main(String[] args) {
		// context:环境--->Spring容器环境.
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans06.xml");

		Car bean1 = context.getBean("car", Car.class);
		Car bean2 = context.getBean("car", Car.class);

		System.out.println("bean1=bean2:" + (bean1 == bean2));

		bean1.move();
		bean2.move();

		context.close();
	}
}
