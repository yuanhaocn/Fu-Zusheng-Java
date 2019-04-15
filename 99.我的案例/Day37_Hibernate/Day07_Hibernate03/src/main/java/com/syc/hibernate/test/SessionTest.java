package com.syc.hibernate.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.syc.hibernate.domain.Employee;
import com.syc.hibernate.utils.HibernateUtil;

public class SessionTest {

	/**
	 * Session与CurrentSession的区别:
	 * 1.内部实现不同:CurrentSession是在SessionImpl类中,利用ThreadLocal机制来实现的;
	 * 2.CurrentSession使用的时候,必须开启事务,否则会报异常,而Session则不一定;
	 * 3.CurrentSession使用的时候,session可以不用关闭,事务提交的时候就已经关闭了.
	 */
	
	@Test
	public void test1() {
		// 每次openSession()方法得到的Session对象都是一个新的对象.
		Session session1 = HibernateUtil.factory.openSession();
		Session session2 = HibernateUtil.factory.openSession();
		System.out.println("第一个=" + (session1 == session2));

		// 每次得到的currentSession对象都是同一个对象.
		Session currentSession1 = HibernateUtil.factory.getCurrentSession();
		Session currentSession2 = HibernateUtil.factory.getCurrentSession();
		System.out.println("第二个=" + (currentSession1 == currentSession2));
	}

	@Test
	public void test2() {

		//Session session = HibernateUtil.factory.openSession();
		Session session = HibernateUtil.factory.getCurrentSession();

		Transaction transaction = session.beginTransaction();
		
		Employee employee = session.get(Employee.class, 23L);

		System.out.println("name=" + employee.getName());

		transaction.commit();
		
		//这句话可以不用写了,因为事务提交的时候,可以自动关闭session.
		//session.close();

	}

}
