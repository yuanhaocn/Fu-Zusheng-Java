package com.syc.spring.transaction03;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.syc.spring.transaction03.web.AccountAction;

public class TransactionTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans03.xml");

		AccountAction action = context.getBean("web", AccountAction.class);
		action.translateMoney();

		context.close();
	}
}
