package com.syc.spring.jdbc05;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.syc.spring.domain.Person;

public class DaoTest {

	@Test
	public void test1() {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans04.xml");
		PersonDao dao = context.getBean("dao", PersonDao.class);
		Person person = new Person();
		person.setId(17);
		person.setName("小狗狗");
		int result = dao.updatePerson(person);
		if (result > 0) {
			System.out.println("更新成功!");
		}
		context.close();
	}

	@Test
	public void test2() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans04.xml");
		PersonDao dao = context.getBean("dao", PersonDao.class);
		List<Person> persons = dao.findAll();
		for (Person p : persons) {
			System.out.println("name=" + p.getName());
		}
		context.close();
	}
}
