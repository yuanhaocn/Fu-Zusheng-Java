package com.syc.spring.aop02;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans02.xml");

		UserDao dao = context.getBean("dao", UserDao.class);

		dao.insert();

		context.close();
	}
}
