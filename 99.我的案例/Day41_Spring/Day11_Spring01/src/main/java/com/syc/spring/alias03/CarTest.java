package com.syc.spring.alias03;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CarTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("beans03.xml");
		
		
		
		//根据id/name得到该bean对应的所有别名
		String[] aliases = context.getAliases("car");
		for(int i=0;i<aliases.length;i++){
			System.out.println("alias="+aliases[i]);
		}
		
		//Car bean = context.getBean("car",Car.class);
		//根据别名,也可以得到对应的bean对象.
		Car bean = context.getBean("奥迪",Car.class);
		bean.move();
		
		context.close();
	}
}
