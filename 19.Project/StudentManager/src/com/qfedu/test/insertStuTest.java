package com.qfedu.test;

import java.util.List;

import org.junit.Test;

import com.qfedu.daoimp.StudentHandleImp;
import com.qfedu.domain.Student;

public class insertStuTest {
	StudentHandleImp studentHandleImp = new StudentHandleImp();

	@Test
	public void test() {
	 Student stu = new Student();
	 stu.setNumber("007");
	 stu.setName("superMan");
	 stu.setAge(110);
	 studentHandleImp.insertStudent(stu);
	}
	
	@Test
	public void selectStu() {
		Student stu = studentHandleImp.selectStudentByNumber("001");
		System.out.println(stu);
	}
	@Test
	public void selectAll() {
		List<Student> stus = studentHandleImp.selectStduents();
		System.out.println(stus);
	}
}
