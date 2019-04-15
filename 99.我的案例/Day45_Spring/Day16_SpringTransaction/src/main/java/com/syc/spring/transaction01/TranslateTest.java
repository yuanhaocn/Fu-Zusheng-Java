package com.syc.spring.transaction01;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.syc.spring.transaction01.web.TranslateAction;

public class TranslateTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans01.xml");
		TranslateAction action = (TranslateAction) context.getBean("action");
		action.translate();
		context.close();
	}
}
