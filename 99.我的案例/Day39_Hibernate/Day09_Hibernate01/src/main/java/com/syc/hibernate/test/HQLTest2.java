package com.syc.hibernate.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;

import com.syc.hibernate.domain.Employee;
import com.syc.hibernate.utils.HibernateUtil;

public class HQLTest2 {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void test1() {
		Session session = HibernateUtil.openSession();

		//Query query = session.getNamedQuery("com.syc.hibernate.domain.Employee.myQuery");
		Query query = session.getNamedQuery(Employee.class.getName()+".myQuery");
		List<Employee> list = query.list();
		for(Employee empl:list){
			System.out.println("name="+empl.getName());
		}
		
		session.close();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void test2() {
		Session session = HibernateUtil.openSession();

		//调用全局的配置
		Query query = session.getNamedQuery("hql");
		List<Employee> list = query.list();
		for(Employee empl:list){
			System.out.println("name="+empl.getName());
		}
		
		session.close();
	}

}
