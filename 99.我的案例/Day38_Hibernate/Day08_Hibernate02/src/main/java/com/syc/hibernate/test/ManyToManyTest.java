package com.syc.hibernate.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.syc.hibernate.domain.Course;
import com.syc.hibernate.domain.Student;
import com.syc.hibernate.utils.HibernateUtil;

public class ManyToManyTest {

	/**
	 * 新建一个学生,新建一门课程,建立两者关系
	 */
	@Test
	public void test1() {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();

		Student stu = new Student();
		stu.setName("小绿");

		Course crs = new Course();
		crs.setName("UI");

		// java.lang.IllegalStateException:
		// org.hibernate.TransientObjectException: object references an unsaved
		// transient instance - save the transient instance beforeQuery
		// flushing: com.syc.hibernate.domain.Student
		// Caused by: org.hibernate.TransientObjectException:
		// 当前对象(crs)不能保存一个临时状态的对象!
		// object references an unsaved transient instance - save the transient
		// instance beforeQuery flushing: com.syc.hibernate.domain.Student
		// Set<Student> students=new HashSet<Student>();
		// students.add(stu);
		// 课程维护关系
		// crs.setStudents(students);
		// session.save(crs);

		//此时正确!
		Set<Course> courses = new HashSet<Course>();
		courses.add(crs);
		// 学生维护关系
		stu.setCourses(courses);

		session.save(stu);

		transaction.commit();
		session.close();
	}
	
	/**
	 * 已存在一门课程,新建一个学生,建立两者关系
	 */
	@Test
	public void test2() {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();

		Course crs = session.get(Course.class, 1);
		
		Student stu=new Student();
		stu.setName("小紫");
		
		Set<Course> courses=new HashSet<Course>();
		courses.add(crs);
		stu.setCourses(courses);
		
		session.save(stu);

		transaction.commit();
		session.close();
	}
	
	/**
	 * 已存在一个学生,新建一门课程,建立两者关系
	 */
	@Test
	public void test3() {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();

		Student stu = session.get(Student.class, 2);
		
		Course crs=new Course();
		crs.setName("VR");
		
		//注意:
		//此时不应该去new一个新的集合对象.否则可能会覆盖原有的选课关系!
		//Set<Course> courses=new HashSet<Course>();
		//courses.add(crs);
		
		stu.getCourses().add(crs);

		transaction.commit();
		session.close();
	}
	
	/**
	 * 已存在一个学生,已存在一门课程,建立两者关系
	 */
	@Test
	public void test4() {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();

		Student stu = session.get(Student.class, 2);
		
		Course crs = session.get(Course.class, 1);
		
		stu.getCourses().add(crs);

		transaction.commit();
		session.close();
	}
	
	/**
	 * 已存在一个学生,从原有的一门课程中转到另一个课程中,建立两者关系
	 */
	@Test
	public void test5() {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();

		Student stu = session.get(Student.class, 2);
		
		Course oldCrs = session.get(Course.class, 1);
		
		//移除原有课程
		stu.getCourses().remove(oldCrs);
		
		//建立关系
		Course newCrs = session.get(Course.class, 2);
		stu.getCourses().add(newCrs);
		
		transaction.commit();
		session.close();
	}
	
	/**
	 * 已存在一个学生,解除与所有课程之间的关系
	 */
	@Test
	public void test6() {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();

		Student stu = session.get(Student.class, 2);
		
		stu.setCourses(null);
		
		transaction.commit();
		session.close();
	}
	
	/**
	 * 已存在一个学生,解除与所有课程之间的关系,再建立起与其他课程之间的关系
	 */
	@Test
	public void test7() {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();

		Student stu = session.get(Student.class, 3);
		
		//解除原有课程之间的关系
		//stu.setCourses(null);
		
		Course crs1 = session.get(Course.class, 3);
		Course crs2=new Course();
		crs2.setName("数学");
		
		Set<Course> courses=new HashSet<Course>();
		courses.add(crs1);
		courses.add(crs2);
		//直接覆盖原有关系
		stu.setCourses(courses);
		
		transaction.commit();
		session.close();
	}
}
