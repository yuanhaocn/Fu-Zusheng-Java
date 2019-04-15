package com.syc.hibernate.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.syc.hibernate.domain.Employee;
import com.syc.hibernate.domain.TestBean;
import com.syc.hibernate.utils.HibernateUtil;

public class TableTest {

	@Test
	public void tableTest() {
		Session session = HibernateUtil.factory.openSession();
		Transaction transaction = session.beginTransaction();

		Employee empl = new Employee();
		empl.setName("宝强");
		empl.setJob("演员");
		empl.setSalery(300000.0);
		session.save(empl);

		transaction.commit();
		session.close();
	}
	
	@Test
	public void table2Test() {
		Session session = HibernateUtil.factory.openSession();
		Transaction transaction = session.beginTransaction();

		TestBean tb=new TestBean();
		tb.setName("杨志2");
		session.save(tb);

		transaction.commit();
		session.close();
	}
}
