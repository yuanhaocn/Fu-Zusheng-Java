package com.syc.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.syc.hibernate.domain.Employee;
import com.syc.hibernate.utils.HibernateUtil;

public class CRUDTest {

	/**
	 * Hibernate: select max(id) from empl Hibernate: insert into empl (name,
	 * job, salery, id) values (?, ?, ?, ?)
	 */
	@Test
	public void insertTest() {
		SessionFactory factory = HibernateUtil.factory;
		// Session是处于Java程序与Hibernate的一个接口,里面提供了一些列操作数据库的API方法.
		Session session = factory.openSession();

		// 一般进行数据库的增删改的时候,都需要开启事务.
		// 开启事务
		Transaction transaction = session.beginTransaction();

		// Hibernate如何实现id的自增长?
		// 原理:先查询表中最大的id值,然后在该值的基础上加1.
		
		// Hibernate的实现数据添加的原理?
		// 1.读取hibernate.cfg.xml--->Employee.hbm.xml文件;
		// 2.xml解析这2个文件,保存解析出的相关信息:表名,列名,类名,属性名等,数据类型;
		// 3.结合反射,获取empl以及session对象的字节码,可以获取到相关的数据值;
		// 4.将数据值在底层通过sql的拼接,实现数据库的CRUD.

		Employee empl = new Employee();
		empl.setName("三胖");
		empl.setJob("总统");
		empl.setSalery(30000.0);

		// 将对象添加到数据库
		session.save(empl);
		
		//session.update();
		
		//session.delete();

		// 提交事务
		transaction.commit();

		// 是否session的资源
		session.close();
	}
	
	/*
	 * Hibernate: 
    select
        employee0_.id as id1_0_0_,
        employee0_.name as name2_0_0_,
        employee0_.job as job3_0_0_,
        employee0_.salery as salery4_0_0_ 
    from
        empl employee0_ 
    where
        employee0_.id=?
	 */
	@Test
	public void queryTest(){
		Session session = HibernateUtil.factory.openSession();
		
		//查询id=1的记录
		Employee empl = session.get(Employee.class, 1L);
		System.out.println("Name="+empl.getName()+",Job="+empl.getJob());

		session.close();
	}
}
