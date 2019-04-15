package com.syc.mybatis;

import org.junit.Test;

import com.syc.mybatis.dao.PersonDao;
import com.syc.mybatis.domain.Card;
import com.syc.mybatis.domain.Person;

public class DaoTest {

	@Test
	public void test1(){
		PersonDao dao=new PersonDao();
		Person person = dao.findById(3);
		System.out.println("name="+person.getName());
		System.out.println("num="+person.getCard().getNum());
	}
	
	@Test
	public void test2(){
		PersonDao dao=new PersonDao();
		Person person = dao.findByName("花荣");
		System.out.println("pid="+person.getPid());
		System.out.println("num="+person.getCard().getNum());
	}
	
	@Test
	public void test3(){
		PersonDao dao=new PersonDao();
		Card card = dao.findByNum("10002");
		System.out.println("name="+card.getPerson().getName());
		System.out.println("num="+card.getNum());
	}
}
