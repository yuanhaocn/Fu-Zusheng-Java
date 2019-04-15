package com.qfedu.test;

import java.sql.Connection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qfedu.daoimp.StudentManagerDaoImp;
import com.qfedu.domain.Student;
import com.qfedu.util.DruidUtil;

public class DaoTest {
	StudentManagerDaoImp studentManagerDaoImp = new StudentManagerDaoImp();

	@Before
	public void ini() {
		Connection connection = DruidUtil.getConnection();
		studentManagerDaoImp.setConnection(connection);
	}
	
	@Test
	public void fun01() {
		int number = studentManagerDaoImp.selectNumberOfStudents();
		System.out.println(number);
	}

	@Test
	public void fun02() {
		List<Student> list = studentManagerDaoImp.selectAllStudents(2, 3);
		System.out.println(list);
	}
}
