package com.syc.mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.syc.mybatis.domain.Course;
import com.syc.mybatis.domain.Student;
import com.syc.mybatis.utils.MybatisUtil;

public class StudentDao {

	// 根据id进行查询
	public List<Student> findStudentByCourseName(String name) {
		SqlSession session = null;
		try {
			session = MybatisUtil.getSession();

			return session.selectList(Student.class.getName() + ".findStudentByCourseName", name);
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			// 提交事务
			session.commit();
			MybatisUtil.closeSession();
		}
		return null;
	}

	// 根据学生姓名,查询课程
	public List<Course> findCourseByStudentName(String name) {
		SqlSession session = null;
		try {
			session = MybatisUtil.getSession();

			return session.selectList(Course.class.getName() + ".findCourseByStudentName", name);
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			// 提交事务
			session.commit();
			MybatisUtil.closeSession();
		}
		return null;
	}

}
