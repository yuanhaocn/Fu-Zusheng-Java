package com.syc.spring.transaction01;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.syc.spring.transaction01.web.AccountAction;

public class TransactionTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans01.xml");

		AccountAction action = context.getBean("web", AccountAction.class);
		action.translateMoney();

		context.close();
	}
}
