package com.syc.dao.test;

import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.syc.dao.dao.PersonDao;
import com.syc.dao.domain.Person;
import com.syc.dao.utils.MybatisUtil;

public class DaoTest {

	@Test
	public void test1() {
		SqlSession session = MybatisUtil.getSession();
		Connection conn = session.getConnection();
		// Mybatis中可以执行原生的SQL语句!
		if (conn != null) {
			System.out.println("数据库已建立连接!");
		} else {
			System.out.println("数据库未建立连接!");
		}
	}

	@Test
	public void test2() {
		PersonDao dao = new PersonDao();
		int result = dao.insertPerson();
		if (result > 0) {
			System.out.println("添加成功!");
		}
	}

	@Test
	public void test3() {
		PersonDao dao = new PersonDao();
		Person p = new Person();
		p.setName("徐宁");
		p.setNickname("金枪手");
		int result = dao.insertPersonWithParams(p);
		if (result > 0) {
			System.out.println("添加成功!");
		}
	}

	@Test
	public void test4() {
		PersonDao dao = new PersonDao();
		List<Person> persons = dao.findAll();
		for (Person p : persons) {
			System.out.println("name=" + p.getName());
		}
	}

	@Test
	public void test5() {
		PersonDao dao = new PersonDao();
		Person person = dao.findById(27);
		System.out.println("name=" + person.getName());
	}
	
	@Test
	public void test6() {
		PersonDao dao = new PersonDao();
		Person person=new Person();
		person.setPid(27);
		person.setName("时迁");
		person.setNickname("鼓上蚤");
		int result = dao.updateById(person);
		if(result>0){
			System.out.println("修改成功!");
		}
	}
	
	@Test
	public void test7() {
		PersonDao dao = new PersonDao();
		Person person=new Person();
		person.setPid(26);
		int result = dao.deleteById(person);
		if(result>0){
			System.out.println("删除成功!");
		}
	}
	
	@Test
	public void test8() {
		PersonDao dao = new PersonDao();
		Person person=new Person();
		person.setName("马林");
		person.setNickname("铁笛仙");
		int result = dao.insertWithDeleteTag(person);
		if(result>0){
			System.out.println("添加成功!");
		}
	}
	
}
