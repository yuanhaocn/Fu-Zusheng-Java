package com.syc.spring.transaction02;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.syc.spring.transaction02.web.AccountAction;

public class TransactionTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans02.xml");

		AccountAction action = context.getBean("web", AccountAction.class);
		action.translateMoney();

		context.close();
	}
}
