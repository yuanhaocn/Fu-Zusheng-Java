package com.syc.spring.homework;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.syc.spring.homework.web.UserController;

public class LayerTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans01.xml");

		UserController bean = context.getBean("web", UserController.class);

		bean.login();

		context.close();
	}
}
