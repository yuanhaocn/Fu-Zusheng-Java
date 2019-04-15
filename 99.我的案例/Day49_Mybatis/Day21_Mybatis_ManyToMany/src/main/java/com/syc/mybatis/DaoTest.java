package com.syc.mybatis;

import java.util.List;

import org.junit.Test;

import com.syc.mybatis.dao.StudentDao;
import com.syc.mybatis.domain.Course;
import com.syc.mybatis.domain.Student;

public class DaoTest {

	@Test
	public void test1() {
		StudentDao dao=new StudentDao();
		List<Student> students = dao.findStudentByCourseName("java");
		for(Student stu: students){
			System.out.println("name="+stu.getName());
			System.out.println("id="+stu.getId());
		}
	}
	
	@Test
	public void test2() {
		StudentDao dao=new StudentDao();
		List<Course> courses = dao.findCourseByStudentName("阮小二");
		
		for(Course crs: courses){
			System.out.println("name="+crs.getName());
			System.out.println("id="+crs.getId());
		}
	}
	
}
