package com.qfedu.daoimp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.qfedu.dao.StudentManagerDao;
import com.qfedu.domain.Student;

public class StudentManagerDaoImp implements StudentManagerDao {
	private Connection connection;
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<Student> selectAllStudents(int thisPage, int pageSize) {
		String sql = "select * from stu limit ?,?";
		QueryRunner queryRunner = new QueryRunner();
		List<Student> lists=null;
		try {
			//计算页面开始的位置
			int startPosition=(thisPage-1)*pageSize;
			lists = queryRunner.query(connection, sql, new BeanListHandler<Student>(Student.class),startPosition,pageSize);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lists;
	}

	@Override
	public int selectNumberOfStudents() {
		String sql="select count(*) from stu";
		QueryRunner queryRunner = new QueryRunner();
		int number=0;
		try {
			Long query = queryRunner.query(connection, sql, new ScalarHandler<Long>());
			 number = query.intValue();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return number;
	}

}
