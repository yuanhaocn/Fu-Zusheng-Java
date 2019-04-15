package com.syc.spring.annotation02;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PrivilegeTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans02.xml");

		ShowSalery bean = context.getBean("showSalery", ShowSalery.class);
		bean.showSalery();

		context.close();
	}
}
