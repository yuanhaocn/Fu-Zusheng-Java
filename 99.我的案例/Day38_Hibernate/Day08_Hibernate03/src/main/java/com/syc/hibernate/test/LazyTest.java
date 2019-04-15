package com.syc.hibernate.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.syc.hibernate.domain.Employee;
import com.syc.hibernate.utils.HibernateUtil;

public class LazyTest {

	@Test
	public void test1() {
		Session session = HibernateUtil.openSession();
		
		//执行该代码的时候,就发出查询的sql语句.
		Employee employee = session.get(Employee.class, 1L);
		
		System.out.println("name="+employee.getName());
		
		session.close();
	}
	
	@Test
	public void test2() {
		Session session = HibernateUtil.openSession();
		
		//以加载的方式进行查询
		Employee employee = session.load(Employee.class, 1L);
		
		//执行该代码的时候,就发出查询的sql语句.
		System.out.println("name="+employee.getName());
		
		session.close();
	}

	@Test
	public void test3() {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();
		
		Employee empl=new Employee();
		empl.setName("卢俊义2");
		session.save(empl);
		
		transaction.commit();
		session.close();
	}
	
	@Test
	public void test4() {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();
		
		Employee empl = session.get(Employee.class, 24L);
		empl.setName("燕青222");
		
		transaction.commit();
		session.close();
	}

}
