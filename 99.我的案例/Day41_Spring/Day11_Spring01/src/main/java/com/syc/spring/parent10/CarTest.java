package com.syc.spring.parent10;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CarTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans10.xml");

		//直接根据父类的id,获取父类对象,然后调用父类对象的方法.
		//Car car = context.getBean("car", Car.class);
		
		//根据子类的id,获取子类对象,然后去调用父类中提供的方法.
		AudiCar car = context.getBean("audi", AudiCar.class);
		String name = car.getName();
		System.out.println("name=" + name);

		context.close();
	}
}
