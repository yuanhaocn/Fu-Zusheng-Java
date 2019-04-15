package com.syc.hibernate.test;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.syc.hibernate.domain.Employee;
import com.syc.hibernate.utils.HibernateUtil;

public class CacheTest {

	@Test
	public void test1() {
		Session session = HibernateUtil.openSession();

		// employee:该对象,在查询的同时,就已经自动的被存放进了一级缓存中.
		Employee empl1 = session.get(Employee.class, 22L);

		// empl2对象其实来自于session缓存.
		Employee empl2 = session.get(Employee.class, 22L);

		System.out.println("empl1=" + empl1.toString());
		System.out.println("empl2=" + empl2.toString());
		System.out.println("(empl1==empl2)=" + (empl1 == empl2));

		// 经过close()方法之后,缓存中还有缓存对象吗?---->没有了,缓存被清空了!
		session.close();
	}

	@Test
	public void test2() {
		Session session = HibernateUtil.openSession();

		// employee:该对象,在查询的同时,就已经自动的被存放进了一级缓存中.
		Employee empl1 = session.get(Employee.class, 22L);

		// empl2对象其实来自于session缓存.
		Employee empl2 = session.get(Employee.class, 22L);

		System.out.println("empl1=" + empl1.toString());
		System.out.println("empl2=" + empl2.toString());

		// 清空缓存,但是并不会销毁session对象
		session.clear();

		// empl2对象其实来自于session缓存.
		Employee empl3 = session.get(Employee.class, 22L);
		System.out.println("empl3=" + empl3.toString());

		// 经过close()方法之后,缓存中还有缓存对象吗?---->没有了,缓存被清空了!
		session.close();
	}

	@Test
	public void test3() {
		Session session = HibernateUtil.openSession();

		session.get(Employee.class, 21L);
		session.get(Employee.class, 22L);

		// Statistics:统计
		// 获取缓存的实体的数量
		int entityCount = session.getStatistics().getEntityCount();

		System.out.println("count=" + entityCount);

		// 获取实体类的key的集合
		Set entityKeys = session.getStatistics().getEntityKeys();
		Iterator iterator = entityKeys.iterator();
		while (iterator.hasNext()) {
			// 遍历出一级缓存中存储的对象.
			Object obj = iterator.next();
			System.out.println("obj=" + obj);
		}

		// 经过close()方法之后,缓存中还有缓存对象吗?---->没有了,缓存被清空了!
		session.close();
	}

	// save()方法可以将对象放到缓存中吗?
	// save()方法也可以将对象添加到缓存中.
	@Test
	public void test4() {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();

		Employee empl = new Employee();
		empl.setName("宋清");
		empl.setJob("安排酒席");
		empl.setSalery(1000);
		session.save(empl);

		int entityCount = session.getStatistics().getEntityCount();
		System.out.println("count=" + entityCount);

		transaction.commit();
		session.close();
	}

	@Test
	public void test5() {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();

		Employee empl = session.get(Employee.class, 23L);
		empl.setSalery(500);
		// session.update(empl);

		int entityCount = session.getStatistics().getEntityCount();
		System.out.println("count=" + entityCount);

		transaction.commit();
		session.close();
	}

	// delete():也可以将对象放到缓存中!
	@Test
	public void test6() {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();

		Employee empl = session.get(Employee.class, 23L);
		session.delete(empl);

		int entityCount = session.getStatistics().getEntityCount();
		System.out.println("count=" + entityCount);

		transaction.commit();
		session.close();
	}

	@Test
	public void test7() {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();

		Employee empl1 = session.get(Employee.class, 21L);
		Employee empl2 = session.get(Employee.class, 22L);

		// session.evict(empl1);
		// session.evict(empl2);
		session.clear();

		int entityCount = session.getStatistics().getEntityCount();
		System.out.println("count=" + entityCount);

		transaction.commit();
		session.close();
	}

	@Test
	public void test8() {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();

		// Employee empl=new Employee();
		// empl.setName("武松");
		// empl.setJob("打虎");
		// empl.setSalery(4000);
		
		Employee empl = session.get(Employee.class, 23L);
		empl.setJob("捕快");
		
		//当对象从临时状态变为持久化状态的时候,此时是执行save操作.
		//当对象本身就是持久化状态的时候,此时是执行update操作.
		session.saveOrUpdate(empl);
		
		transaction.commit();
		session.close();
	}
}
