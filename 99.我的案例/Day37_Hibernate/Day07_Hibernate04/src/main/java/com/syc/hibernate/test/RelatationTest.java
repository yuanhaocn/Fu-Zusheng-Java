package com.syc.hibernate.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.syc.hibernate.domain.Course;
import com.syc.hibernate.domain.Student;
import com.syc.hibernate.utils.HibernateUtil;

public class RelatationTest {

	// 新建一门课,新建一个学生,建立俩者之间的关系
	@Test
	public void test1() {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();

		// 新建一个学生
		// 临时状态
		Student stu = new Student();
		stu.setName("张飞");
		// 变成持久化状态
		session.save(stu);

		// 新建一门课
		// 临时状态
		Course crs = new Course();
		crs.setName("VR");

		// 建立学生与课程之间的关系
		Set<Student> students = new HashSet<Student>();
		students.add(stu);
		crs.setStudents(students);

		// 持久状态
		session.save(crs);

		transaction.commit();
		session.close();
	}

	// 已经存在一个学生,已经存在一门课,建立起两者之间的关系.
	@Test
	public void test2() {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();

		// 已经存在一个学生:查询
		Student stu = session.get(Student.class, 1);

		// 已经存在一门课程;查询
		Course crs = session.get(Course.class, 4);

		// 维护关系?
		// Set<Student> students=new HashSet<Student>();
		// students.add(stu);
		// crs.setStudents(students);

		// 这么写才对!
		crs.getStudents().add(stu);

		// save()/update()是否可以不写?
		// session.save(crs);

		transaction.commit();
		session.close();
	}

	// 已经存在一个学生,新建一门课,建立起两者之间的关系.
	@Test
	public void test3() {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();

		// 已经存在一个学生:查询
		Student stu = session.get(Student.class, 2);

		// 新建一门课
		Course crs = new Course();
		crs.setName("体育");

		// 建立两者的关系.
		Set<Student> students = new HashSet<Student>();
		students.add(stu);
		crs.setStudents(students);

		session.save(crs);

		transaction.commit();
		session.close();
	}

	// 已存在一门课,新建一个学生,建立起两者之间的关系.
	@Test
	public void test4() {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();

		Student stu = new Student();
		stu.setName("小明");
		session.save(stu);

		Course crs = session.get(Course.class, 3);

		crs.getStudents().add(stu);

		transaction.commit();
		session.close();
	}

	// 已存在一个学生,将该学生从一门课转变到另一门课程中,建立起两者之间的关系.
	@Test
	public void test5() {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();

		// 已存在学生:查询
		Student stu = session.get(Student.class, 1);

		// 原有课程:查询
		Course crs = session.get(Course.class, 4);

		// 移除原有的关系
		crs.getStudents().remove(stu);

		// 查询出新课程
		Course newCrs = session.get(Course.class, 1);

		// 建立起新的关系
		newCrs.getStudents().add(stu);

		transaction.commit();
		session.close();
	}

	// 已存在一门课程,先将该课程中原有的学生解除,再建立起与其他学生之间的关系
	@Test
	public void test6() {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();

		// 原有课程:查询
		Course crs = session.get(Course.class, 1);
		
		crs.getStudents().clear();
		
		Student stu=new Student();
		stu.setName("小王");
		
		session.save(stu);
		
		crs.getStudents().add(stu);

		transaction.commit();
		session.close();
	}
	
	@Test
	public void test7() {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();

		// 原有课程:查询
		Course crs = session.get(Course.class, 1);
		
		//解除原有关系
		//crs.getStudents().clear();
		crs.setStudents(null);
		
		Student stu1=new Student();
		stu1.setName("小张");
		//之所以可以不写该方法:是因为,Course.hbm.xml文件中,配置了cascade="save-update",实现了级联添加!
		//session.save(stu1);
		
		Student stu2 = session.get(Student.class, 3);
		
		//建立新的关系
		Set<Student> students=new HashSet<Student>();
		students.add(stu1);
		students.add(stu2);
		crs.setStudents(students);

		transaction.commit();
		session.close();
	}
}
