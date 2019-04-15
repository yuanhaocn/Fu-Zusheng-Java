package com.syc.spring.aop01;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans01.xml");

		//UserDao dao = context.getBean("dao", UserDao.class);
		//dao.insert();

		UserAction bean = context.getBean("web",UserAction.class);
		bean.register();
		
		context.close();
	}
}
