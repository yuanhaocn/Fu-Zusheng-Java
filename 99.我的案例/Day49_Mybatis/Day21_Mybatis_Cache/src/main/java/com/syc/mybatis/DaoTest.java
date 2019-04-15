package com.syc.mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.syc.mybatis.domain.Person;
import com.syc.mybatis.utils.MybatisUtil;

public class DaoTest {

	@Test
	public void test1() {
		SqlSession session = MybatisUtil.getSession();

		// 默认情况下,对于id相同的两个对象,Mybatis的一级缓存就自动开启了.
		Person p1 = session.selectOne(Person.class.getName() + ".findById", 2);
		Person p2 = session.selectOne(Person.class.getName() + ".findById", 2);

		System.out.println("(p1==p2)=" + (p1 == p2));
		System.out.println("p1=" + p1.toString());
		System.out.println("p2=" + p2.toString());

		// session.close();
		// 清空了一级缓存!---->说明一级缓存属于SqlSession级别的.
		// session.clearCache();
		// 当事务被提交的时候,一级缓存会被清空!
		session.commit();

		// SqlSession session = MybatisUtil.getSession();
		Person p3 = session.selectOne(Person.class.getName() + ".findById", 2);
		System.out.println("p3=" + p3.toString());
	}

	@Test
	public void test2() {
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader("mybatis.xml");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
			SqlSession session1 = factory.openSession();
			SqlSession session2 = factory.openSession();

			System.out.println("session1==session2=" + (session1 == session2));

			Person p1 = session1.selectOne(Person.class.getName() + ".findById", 2);
			
			System.out.println("p1="+p1.toString());
			//只要session一close(),在这之前,查询的对象,会被自动存放进二级缓存.
			session1.close();
			
			Person p2 = session2.selectOne(Person.class.getName() + ".findById", 2);
			//p2的hash值等同于p1,说明p2对象来自于二级缓存.
			System.out.println("p2="+p2.toString());
			session2.close();
			
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
