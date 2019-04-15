package com.syc.spring.annotation05;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.syc.spring.annotation05.web.UserController;

public class LayerTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans05.xml");

		UserController bean = context.getBean("web", UserController.class);

		bean.login();

		context.close();
	}
}
