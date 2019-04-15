package com.syc.spring.aop01;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans01.xml");

		//cglib代理中的父类.
		//cglib代理中以目标类做为父类SingStar,Spring中AOP的内部,会以SingStar为模板,
		//创建出一个子代理对象.
		SingStar star = context.getBean("star", SingStar.class);

		star.sing();

		context.close();
	}
}
