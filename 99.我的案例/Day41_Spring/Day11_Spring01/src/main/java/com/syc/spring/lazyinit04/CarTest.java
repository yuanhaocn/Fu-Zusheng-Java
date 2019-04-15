package com.syc.spring.lazyinit04;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CarTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans04.xml");

		//懒加载之后,必须调用该方法,才会创建对应的对象!
		Car bean = context.getBean("car", Car.class);
		bean.move();

		context.close();
	}
}
