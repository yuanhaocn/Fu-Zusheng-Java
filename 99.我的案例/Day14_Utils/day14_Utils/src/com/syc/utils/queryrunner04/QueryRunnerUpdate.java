package com.syc.utils.queryrunner04;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.junit.Test;

import com.syc.utils.JdbcUtil;
import com.syc.utils.bean.User;

public class QueryRunnerUpdate {

	@Test
	public void insertTest() {
		try {
			Connection conn = JdbcUtil.getConnection();
			String sql = "insert into user (username,password) values(?,?)";

			QueryRunner qr = new QueryRunner();
			// 添加操作.一般不会用这个insert()方法进行数据的添加.
			qr.insert(conn, sql, new ResultSetHandler<User>() {
				@Override
				public User handle(ResultSet rs) throws SQLException {
					return null;
				}
			}, "Tom", "4444");

			DbUtils.close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void insertTest2() {
		try {
			Connection conn = JdbcUtil.getConnection();

			String sql = "insert into user (username,password) values(?,?)";
			QueryRunner qr = new QueryRunner();
			int result = qr.update(conn, sql, "杰瑞", "555");

			if (result > 0) {
				System.out.println("更新成功!");
			}

			DbUtils.close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void updateTest() {
		try {
			Connection conn = JdbcUtil.getConnection();

			String sql = "update user set username=?,password=? where id=?";
			QueryRunner qr = new QueryRunner();
			int result = qr.update(conn, sql, "杰瑞2", "666", 5);

			if (result > 0) {
				System.out.println("更新成功!");
			}

			DbUtils.close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void deleteTest() {
		try {
			Connection conn = JdbcUtil.getConnection();

			String sql = "delete from user where id=?";
			QueryRunner qr = new QueryRunner();
			int result = qr.update(conn, sql, 5);

			if (result > 0) {
				System.out.println("更新成功!");
			}

			DbUtils.close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
