package com.syc.spring.annotation03;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PrivilegeTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans03.xml");

		ShowSalery bean = context.getBean("showSalery", ShowSalery.class);
		bean.showSalery();

		context.close();
	}
}
