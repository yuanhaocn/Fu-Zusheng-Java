package com.qfedu.daoimp;
/**
 * 使用Dbutil进行查询工作，简化查询步骤强对dbutil查询结构集的理解
 */
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.qfedu.dao.StudentHandle;
import com.qfedu.domain.Student;
import com.qfedu.util.DButil;

public class StudentHandleImp implements StudentHandle {
	// 构建连接对象，由action层传入
		private Connection connection;
		public Connection getConnection() {return connection;}
		public void setConnection(Connection connection) {this.connection = connection;}
/*
 *DbUtil 的insert操作
 */
		@Override
		public void insertStudent(Student stu) {
			QueryRunner queryRunner = new QueryRunner();
			String sql = "insert into Student(number,name,age) values(?,?,?)";
			try {
				queryRunner.update(connection, sql,stu.getNumber(),stu.getName(),stu.getAge());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

		/*
		 *使用DBUtil简化select查询操作
		 */
		
		@Override
		public Student selectStudentByNumber(String number) {
			Student student =null;
			QueryRunner queryRunner = new QueryRunner();
			String sql = "select * from student where number =?";
			try {
				student = queryRunner.query(connection, sql, new BeanHandler<Student>(Student.class),number);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return student;
		}

		/*
		 *使用dbutil查询所有记录，使用new BeanListHandler<>();
		 */
		@Override
		public List<Student> selectStduents() {
			String sql = "select * from student";
			QueryRunner queryRunner = new QueryRunner();
			List<Student> query=null;
			try {
				query = queryRunner.query(connection, sql, new BeanListHandler<Student>(Student.class));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return query;
		}

	
}
