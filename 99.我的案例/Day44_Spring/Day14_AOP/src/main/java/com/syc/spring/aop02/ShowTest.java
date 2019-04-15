package com.syc.spring.aop02;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ShowTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans02.xml");

		// 获取切面对象
		// PrivilegeAspect aspect = context.getBean("aspect",
		// PrivilegeAspect.class);
		// 获取切面类中的集合
		// List<Privilege> privileges = aspect.getPrivileges();
		// Privilege privilege = new Privilege();
		// privilege.setAccess("3333admin");
		// privileges.add(privilege);

		ShowSalery show = context.getBean("showSalery", ShowSalery.class);
		show.showSalery();

		context.close();
	}
}
