package com.syc.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.Test;

import com.syc.hibernate.utils.HibernateUtil;

public class QueryCacheTest {

	/*
	 * 当同时配置了一二级缓存及查询缓存的时候,此时数据的加载流程:
	 * 此时应该分情况讨论:
	 * get(Employee.class,3);
	 * 1.如果加载的数据是对象:
	 *   ①.先取出该对象的id,根据这个id去查询缓存中找这个id,看之前有没有存储过这个id,如果没有该id,说明之前
	 *     从来没有操作过该对象,则直接去数据库中查找.
	 *     如果有该id,以该id为线索,去一级缓存中加载对应的对象;
	 *   ②.此时去一级缓存中根据id加载该对象,判断一级缓存中是否存在该对象,如果有,直接用;
	 *     如果没有,则去二级缓存中加载该对象,
	 *   ③.此时再判断二级缓存中是否存在该对象; 如果有,直接用,如果没有,则去数据库中加载该对象.
	 *     当找到了该对象之后,则分别存在二级和一级缓存中;
	 * 2.如果加载的数据是基本数据:  
	 *   会先去查询缓存中查找对应的数据,看有没有,有就直接用该数据,否则去查询数据库.
	 */
	
	// HQL执行的时候,一二级缓存如何实现.
	@SuppressWarnings("rawtypes")
	@Test
	public void test1() {
		Session session = HibernateUtil.openSession();

		//查询对象
		//Query query = session.createQuery("select e from Employee e");
		//查询对象里的属性----->操作的是基本的数据类型和简单数据!
		//此时,会将name这个数据放进查询缓存中!不会放进一二级缓存!
		Query query = session.createQuery("select e.name from Employee e");
		
		//第二次查询,就是在使用查询缓存.但是注意:必须保证第二次的查询语句与第一次完全一样!
		//Query query = session.createQuery("select e.name from Employee e");

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

		//查询缓存的统计方法
		long queryCachePutCount = factory.getStatistics().getQueryCachePutCount();
		System.out.println("查询缓存putCount=" + queryCachePutCount);
		
		session.close();
		
	}
}
