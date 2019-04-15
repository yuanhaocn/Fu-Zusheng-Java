package com.syc.quartz;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SchedulerTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("beans.xml");
	}
}
