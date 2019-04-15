package com.syc.spring.transaction02;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.syc.spring.transaction02.web.TranslateAction;

public class TranslateTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans02.xml");
		TranslateAction action = (TranslateAction) context.getBean("action");
		action.translate();
		context.close();
	}
}
