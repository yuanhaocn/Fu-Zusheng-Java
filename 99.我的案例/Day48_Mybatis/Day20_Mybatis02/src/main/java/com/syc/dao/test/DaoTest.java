package com.syc.dao.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.syc.dao.dao.PersonDao;
import com.syc.dao.domain.Person;

public class DaoTest {

	@Test
	public void test1() {
		PersonDao dao = new PersonDao();
		List<Person> persons = dao.findByPage(0, 5);
		for (Person p : persons) {
			System.out.println("name=" + p.getName());
		}
	}

	@Test
	public void test2() {
		PersonDao dao = new PersonDao();
		// List<Person> persons = dao.findByPageWithLike("%史%", 0, 10);
		List<Person> persons = dao.findByPageWithLike("史", 0, 2);
		for (Person p : persons) {
			System.out.println("name=" + p.getName());
		}
	}

	@Test
	public void test3() {
		PersonDao dao = new PersonDao();
		// List<Person> persons = dao.findByCondition("石勇","石将军");
		List<Person> persons = dao.findByCondition(null, null);
		for (Person p : persons) {
			System.out.println("name=" + p.getName());
		}
	}

	@Test
	public void test4() {
		PersonDao dao = new PersonDao();
		int result = dao.updateDynamic("20", "小宋江", "小黑子");
		System.out.println("result=" + result);
	}

	@Test
	public void test5() {
		PersonDao dao = new PersonDao();
		Person person = new Person();
		person.setPid(21);
		int result = dao.deleteDynamic(person);
		System.out.println("result=" + result);
	}

	@Test
	public void test6() {
		PersonDao dao = new PersonDao();
		int result = dao.deleteByArray(24, 25, 30, 38, 78, 90);
		System.out.println("result=" + result);
	}

	@Test
	public void test7() {
		PersonDao dao = new PersonDao();
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(20);
		ids.add(22);
		ids.add(24);
		ids.add(34);
		ids.add(44);
		int result = dao.deleteByList(ids);
		System.out.println("result=" + result);
	}

	@Test
	public void test8() {
		PersonDao dao = new PersonDao();
		//int result = dao.insertDynamic("张清", "没羽箭");
		int result = dao.insertDynamic("张青", null);
		System.out.println("result=" + result);
	}

}
