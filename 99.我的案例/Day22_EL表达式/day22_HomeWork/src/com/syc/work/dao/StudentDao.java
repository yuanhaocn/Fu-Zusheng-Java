package com.syc.work.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.syc.work.bean.Student;
import com.syc.work.utils.JdbcUtil;

public class StudentDao {

	public List<Student> queryAll() {
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from student";
			QueryRunner qr = new QueryRunner();
			return qr.query(conn, sql, new BeanListHandler<>(Student.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
}
