package com.qfedu.daoimp;
/**
 * ʹ��Dbutil���в�ѯ�������򻯲�ѯ����ǿ��dbutil��ѯ�ṹ�������
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
	// �������Ӷ�����action�㴫��
		private Connection connection;
		public Connection getConnection() {return connection;}
		public void setConnection(Connection connection) {this.connection = connection;}
/*
 *DbUtil ��insert����
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
		 *ʹ��DBUtil��select��ѯ����
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
		 *ʹ��dbutil��ѯ���м�¼��ʹ��new BeanListHandler<>();
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
