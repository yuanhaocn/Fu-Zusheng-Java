package com.syc.hibernate.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.syc.hibernate.domain.Card;
import com.syc.hibernate.domain.Person;
import com.syc.hibernate.utils.HibernateUtil;

public class OneToOneTest {

	// 新建一个人,新建一个身份证号,建立两者之间的关系
	@Test
	public void test1() {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();

		Person person = new Person();
		person.setName("傻蛋");

		Card card = new Card();
		card.setNum("10005");

		// 建立两者关系
		person.setCard(card);

		session.save(person);

		transaction.commit();
		session.close();
	}

	// 查询一个人,根据人的姓名得到他对应的身份证号
	@Test
	public void test2() {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();

		Person person = session.get(Person.class, 5);

		String num = person.getCard().getNum();

		System.out.println("num=" + num);

		transaction.commit();
		session.close();
	}

	// 查询一个身份证号,根据身份证号得到对应的名字
	@Test
	public void test3() {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();

		Card card = session.get(Card.class, 3);

		String name = card.getPerson().getName();

		System.out.println("name=" + name);

		transaction.commit();
		session.close();
	}

	// 让1号的人和2号的人,让1号的人去占用2号人的身份证
	@Test
	public void test4() {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();

		Person person = session.get(Person.class, 1);
		
		Card card = session.get(Card.class, 2);
		
		person.setCard(card);

		transaction.commit();
		session.close();
	}
}
