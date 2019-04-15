package com.syc.hibernate.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.syc.hibernate.domain.Employee;
import com.syc.hibernate.utils.HibernateUtil;

public class StateTest {

	/**
	 * 1.   Employee empl=new Employee();---->临时状态
	   2.	empl.setName("阮小二");
	   3.	empl.setJob("打渔");
	   4.	empl.setSalery(2000);
	   5.	session.save(empl);----->开始变成持久化状态
	   6.	transaction.commit();--->注意:只有调用了commit()方法之后,数据才真正的添加到了数据库中!
	   7.	session.close();---->此时,empl变成游离状态.
	   save()/update()/get()/load():都可以把一个对象从临时状态变成持久化状态;
	   delete():把持久化状态的对象变成删除状态.
	   close()/evict()/clear():把持久化状态的对象变成游离状态.
	 */
	@Test
	public void test1(){
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();
		
		Employee empl=new Employee();
		empl.setName("阮小二");
		empl.setJob("打渔");
		empl.setSalery(2000);
		session.save(empl);
		
		transaction.commit();
		session.close();
	}
	
	@Test
	public void test2(){
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();
		
		//empl:持久化状态
		Employee empl = session.get(Employee.class, 22L);
		
		empl.setName("阮小七");
		
		//当对象的状态都是持久化状态的时候,不必调用update().
		//修改用户名称
		//session.update(empl);
		
		transaction.commit();
		
		session.close();
	}
	
	@Test
	public void test3(){
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();
		
		//empl:持久化状态
		Employee empl = session.get(Employee.class, 22L);
		
		empl.setName("阮小八");
		
		//将对象从一级缓存中清除,对象状态变为游离状态!
		session.evict(empl);
		//把一级缓存中所有的对象都清除
		//session.clear();
		
		//此时对象的状态发生了改变,必须明确的调用update()方法才能真正的进行更新操作.
		//修改用户名称
		session.update(empl);
		
		transaction.commit();
		
		session.close();
	}
	
	@Test
	public void test4(){
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();
		
		//empl:持久化状态
		Employee empl = session.get(Employee.class, 22L);
		empl.setName("阮小九");
		
		//empl2:临时状态
		Employee empl2=new Employee();
		empl2.setName("李俊");
		empl2.setJob("海盗");
		empl2.setSalery(6000);
		
		//必须调用save()方法,才能实现数据的保存.
		//empl2由临时状态变为持久状态!
		session.save(empl2);
		
		//清空一级缓存中所有的对象--->能够把所有处于持久化状态的对象,变成游离状态!
		//当对象从持久化状态变为游离(脱管)状态的时候,该对象的任何数据数据库操作都无效!
		session.clear();
		
		transaction.commit();
		
		session.close();
	}
}
