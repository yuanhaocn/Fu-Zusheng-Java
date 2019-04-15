package com.syc.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;

import com.syc.hibernate.domain.Employee;
import com.syc.hibernate.utils.HibernateUtil;

public class CacheTest {

	/*
	 * get()/load()等方法来说: 1.会把操作的对象放进一级缓存中; 2.也会把该对象放进二级缓存中.
	 * 
	 * 当同时配置了一级缓存和二级缓存,此时加载该对象的流程:
	 * 当加载数据(对象)的时候,先去一级缓存中加载该对象,判断一级缓存中是否存在该对象,如果有,直接用;
	 * 如果没有,则去二级缓存中加载该对象,此时再判断二级缓存中是否存在该对象; 如果有,直接用,如果没有,则去数据库中加载该对象.
	 * 当找到了该对象之后,则分别存在二级和一级缓存中.....
	 * 
	 * 一级缓存属于Session对象,当Session被关闭,清空的时候,一级缓存中的对象则被清理掉;
	 * 二级缓存属于SessionFactory对象,当Factory被close的时候,二级缓存中的对象被清理掉.
	 */
	@Test
	public void test1() {
		Session session = HibernateUtil.openSession();

		// 在查询的同时,存放进了一级缓存
		session.get(Employee.class, 5L);

		// 不会影响二级缓存,只会影响一级缓存.
		// session.evict(object);
		// session.clear();

		int entityCount = session.getStatistics().getEntityCount();
		System.out.println("一级缓存数量=" + entityCount);

		// 一级缓存被清理掉!
		session.close();

		SessionFactory factory = session.getSessionFactory();
		// SessionFactory factory = HibernateUtil.factory;
		long secondLevelCachePutCount = factory.getStatistics().getSecondLevelCachePutCount();
		long entityLoadCount = factory.getStatistics().getEntityLoadCount();
		// long entityUpdateCount =
		// factory.getStatistics().getEntityUpdateCount();
		System.out.println("二级缓存putCount=" + secondLevelCachePutCount);
		System.out.println("二级缓存loadCount=" + entityLoadCount);
		// System.out.println("二级缓存updateCount="+entityUpdateCount);
	}

	// save()可以一级缓存,能不能操作二级缓存?
	// 不能操作二级缓存!
	@Test
	public void test2() {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();

		Employee empl = new Employee();
		empl.setName("施恩");
		empl.setJob("开酒店");
		empl.setSalery(2000);
		session.save(empl);

		int entityCount = session.getStatistics().getEntityCount();
		System.out.println("一级缓存数量=" + entityCount);

		SessionFactory factory = session.getSessionFactory();
		long secondLevelCachePutCount = factory.getStatistics().getSecondLevelCachePutCount();
		long loadCount = factory.getStatistics().getEntityLoadCount();
		long insertCount = factory.getStatistics().getEntityInsertCount();
		System.out.println("二级缓存putCount=" + secondLevelCachePutCount);
		System.out.println("二级缓存loadCount=" + loadCount);
		System.out.println("二级缓存insertCount=" + insertCount);

		transaction.commit();
		session.close();
	}

	// update()/delete可以一级缓存,能不能操作二级缓存?
	// 不能操作二级缓存!
	@Test
	public void test3() {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();

		Employee empl = session.get(Employee.class, 25L);
		empl.setJob("员外");
		session.update(empl);

		int entityCount = session.getStatistics().getEntityCount();
		System.out.println("一级缓存数量=" + entityCount);

		SessionFactory factory = session.getSessionFactory();
		long secondLevelCachePutCount = factory.getStatistics().getSecondLevelCachePutCount();
		long loadCount = factory.getStatistics().getEntityLoadCount();
		long updateCount = factory.getStatistics().getEntityUpdateCount();
		System.out.println("二级缓存putCount=" + secondLevelCachePutCount);
		System.out.println("二级缓存loadCount=" + loadCount);
		System.out.println("二级缓存updateCount=" + updateCount);

		transaction.commit();
		session.close();
	}

	// HQL执行的时候,一二级缓存如何实现.
	@SuppressWarnings("rawtypes")
	@Test
	public void test4() {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();

		Query query = session.createQuery("from Employee");

		// 明确开启二级缓存功能.
		query.setCacheable(true);

		// 在hql中,真正的查询操作,是在执行list()方法才发出的.
		query.list();

		int entityCount = session.getStatistics().getEntityCount();
		System.out.println("一级缓存数量=" + entityCount);

		SessionFactory factory = session.getSessionFactory();
		long secondLevelCachePutCount = factory.getStatistics().getSecondLevelCachePutCount();
		long loadCount = factory.getStatistics().getEntityLoadCount();
		System.out.println("二级缓存putCount=" + secondLevelCachePutCount);
		System.out.println("二级缓存loadCount=" + loadCount);

		long secondLevelCacheHitCount = factory.getStatistics().getSecondLevelCacheHitCount();
		long secondLevelCacheMissCount = factory.getStatistics().getSecondLevelCacheMissCount();

		System.out.println("二级缓存命中=" + secondLevelCacheHitCount);
		System.out.println("二级缓存未命中=" + secondLevelCacheMissCount);

		transaction.commit();
		session.close();
	}

	// HQL执行查询的时候,可以操作一二级缓存.
	// update/delete的时候,可以执行吗?
	//既不能操作一级缓存,也不能操作二级缓存.
	@SuppressWarnings("rawtypes")
	@Test
	public void test5() {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();

		Query query = session.createQuery("update Employee set job=? where name=?");
		query.setParameter(0, "玩");
		query.setParameter(1, "燕青222");

		// 明确开启二级缓存功能.
		query.setCacheable(true);

		//进行更新操作
		query.executeUpdate();

		int entityCount = session.getStatistics().getEntityCount();
		System.out.println("一级缓存数量=" + entityCount);

		SessionFactory factory = session.getSessionFactory();
		long secondLevelCachePutCount = factory.getStatistics().getSecondLevelCachePutCount();
		long updateCount = factory.getStatistics().getEntityUpdateCount();
		System.out.println("二级缓存putCount=" + secondLevelCachePutCount);
		System.out.println("二级缓存updateCount=" + updateCount);

		transaction.commit();
		session.close();
	}
}
