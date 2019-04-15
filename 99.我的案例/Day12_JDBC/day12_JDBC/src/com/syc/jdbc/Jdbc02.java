package com.syc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class Jdbc02 {

	private String url = "jdbc:mysql://localhost:3306/db01";
	private String user = "root";
	private String password = "syc";

	// 通过java代码,在db01中创建一个表.
	@Test
	public void createTable() {
		Connection conn = null;
		Statement stmt = null;
		try {
			// 1.先建立驱动程序
			Class.forName("com.mysql.jdbc.Driver");

			// 2.再建立数据库连接
			conn = DriverManager.getConnection(url, user, password);

			// 3.利用conn对象获取Statement对象.
			// Statement用来执行具体的sql语句.
			stmt = conn.createStatement();

			// 4.执行建表语句
			// execute(sql)可以执行所有的sql语句.
			String sql = "CREATE TABLE person (id INT PRIMARY KEY AUTO_INCREMENT,pname VARCHAR(30),sex VARCHAR(10))";
			// 只有sql语句是查询语句并且还得有结果集的时候,才是true;
			// 其他情况下一律是false.
			stmt.execute(sql);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//5.释放资源
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
