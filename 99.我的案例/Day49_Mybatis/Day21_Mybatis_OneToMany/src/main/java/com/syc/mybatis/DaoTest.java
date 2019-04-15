package com.syc.mybatis;

import java.util.List;

import org.junit.Test;

import com.syc.mybatis.dao.PersonDao;
import com.syc.mybatis.domain.Grade;
import com.syc.mybatis.domain.Person;

public class DaoTest {

	@Test
	public void test1() {
		PersonDao dao=new PersonDao();
		List<Person> persons = dao.findPesonsByGradeName("3班");
		for(Person p: persons){
			System.out.println("name="+p.getName());
		}
	}
	
	@Test
	public void test2() {
		PersonDao dao=new PersonDao();
		Grade grade = dao.findGradeByPersonName("李逵");
		System.out.println("name="+grade.getName());
	}

}
