package com.syc.jdbc;

import java.sql.Connection;
import java.sql.Statement;

import org.junit.Test;

public class Jdbc04 {

	@Test
	public void insertTest() throws Exception {
		// 1.注册驱动

		// 2.建立数据库连接
		Connection conn = JdbcUtil.getConnection();

		// 3.得到Statement对象
		Statement stmt = conn.createStatement();

		// 4.执行具体的SQL语句
		// stmt.execute(sql);
		String sql = "INSERT INTO person (pname,sex) VALUES('花荣','女')";
		int result = stmt.executeUpdate(sql);

		if (result > 0) {
			System.out.println("添加成功!");
		}

		// 5.释放资源
		JdbcUtil.close(stmt, conn);
	}

	@Test
	public void updateTest() throws Exception {
		// 1.注册驱动

		// 2.建立数据库连接
		Connection conn = JdbcUtil.getConnection();

		// 3.得到Statement对象
		Statement stmt = conn.createStatement();

		// 4.执行具体的SQL语句
		// stmt.execute(sql);
		String sql = "UPDATE person SET sex='男' WHERE pname='花荣'";
		int result = stmt.executeUpdate(sql);

		if (result > 0) {
			System.out.println("修改成功!");
		}

		// 5.释放资源
		JdbcUtil.close(stmt, conn);
	}

	@Test
	public void deleteTest() throws Exception {
		// 1.注册驱动

		// 2.建立数据库连接
		Connection conn = JdbcUtil.getConnection();

		// 3.得到Statement对象
		Statement stmt = conn.createStatement();

		// 4.执行具体的SQL语句
		// stmt.execute(sql);
		String sql = "DELETE FROM person WHERE pname='花荣'";
		int result = stmt.executeUpdate(sql);

		if (result > 0) {
			System.out.println("删除成功!");
		}

		// 5.释放资源
		JdbcUtil.close(stmt, conn);
	}

	@Test
	public void insert2Test() throws Exception {
		// 1.注册驱动

		// 2.建立数据库连接
		Connection conn = JdbcUtil.getConnection();

		// 3.得到Statement对象
		Statement stmt = conn.createStatement();

		// 4.执行具体的SQL语句
		// stmt.execute(sql);
		String sql = "INSERT INTO person (pname,sex) VALUES('花荣','女')";
		for (int i = 0; i < 30; i++) {
			stmt.executeUpdate(sql);
		}

		// 5.释放资源
		JdbcUtil.close(stmt, conn);
	}

}
