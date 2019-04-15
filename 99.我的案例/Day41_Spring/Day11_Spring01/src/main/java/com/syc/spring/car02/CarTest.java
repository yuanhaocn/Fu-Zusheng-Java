package com.syc.spring.car02;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CarTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans02.xml");

		// 静态工厂创建
		// Car bean = context.getBean("staticCar",Car.class);
		// bean.move();

		// 实例工厂的创建方式
		Car bean = context.getBean("instanceCar", Car.class);
		bean.move();

		context.close();
	}
}
