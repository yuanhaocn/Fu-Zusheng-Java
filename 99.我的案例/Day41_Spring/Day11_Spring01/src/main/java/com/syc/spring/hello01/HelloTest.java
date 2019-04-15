package com.syc.spring.hello01;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloTest {

	public static void main(String[] args) {
		// 对象的创建,现在是在"自己(程序)"手里
		// HelloWorld world=new HelloWorld();
		// world.printMsg();

		// 把对象的创建和控制权交给(反转)给别人----->"Spring容器".---->该过程就是所谓的"控制反转".

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans01.xml");
		
		//根据id/name从Sring容器中获取指定的类型
		HelloWorld world = (HelloWorld) context.getBean("hello");
		//HelloWorld bean = context.getBean("hello", HelloWorld.class);
		world.printMsg();
		
		//释放弱引用对象所占用的资源
		context.close();
	}
}
