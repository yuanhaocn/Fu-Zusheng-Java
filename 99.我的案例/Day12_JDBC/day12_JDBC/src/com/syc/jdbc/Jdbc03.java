package com.syc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class Jdbc03 {

	private String url = "jdbc:mysql://localhost:3306/db01";
	private String user = "root";
	private String password = "syc";

	@Test
	public void insert() {
		Connection conn = null;
		Statement stmt = null;
		try {
			// 1.建立驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 2.建立数据库连接
			conn = DriverManager.getConnection(url, user, password);
			// 3.创建Statement对象
			stmt = conn.createStatement();
			// 4.执行具体的SQL语句
			// stmt.execute(sql);
			String sql = "INSERT INTO person (pname,sex) VALUES('林冲','男')";
			// 返回结构:受该SQL语句影响的行数.
			int result = stmt.executeUpdate(sql);
			if (result > 0) {
				System.out.println("添加成功!");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			// 5.释放资源
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
	
	@Test
	public void update() {
		Connection conn = null;
		Statement stmt = null;
		try {
			// 1.建立驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 2.建立数据库连接
			conn = DriverManager.getConnection(url, user, password);
			// 3.创建Statement对象
			stmt = conn.createStatement();
			// 4.执行具体的SQL语句
			// stmt.execute(sql);
			String sql = "UPDATE person SET sex='女' WHERE id=1";
			// 返回结构:受该SQL语句影响的行数.
			int result = stmt.executeUpdate(sql);
			if (result > 0) {
				System.out.println("修改成功!");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			// 5.释放资源
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
	
	@Test
	public void delete() {
		Connection conn = null;
		Statement stmt = null;
		try {
			// 1.建立驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 2.建立数据库连接
			conn = DriverManager.getConnection(url, user, password);
			// 3.创建Statement对象
			stmt = conn.createStatement();
			// 4.执行具体的SQL语句
			// stmt.execute(sql);
			String sql = "DELETE FROM person WHERE id=1";
			// 返回结构:受该SQL语句影响的行数.
			int result = stmt.executeUpdate(sql);
			if (result > 0) {
				System.out.println("删除成功!");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			// 5.释放资源
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
	
	@Test
	public void updateMethod(String sql) {
		Connection conn = null;
		Statement stmt = null;
		try {
			// 1.建立驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 2.建立数据库连接
			conn = DriverManager.getConnection(url, user, password);
			// 3.创建Statement对象
			stmt = conn.createStatement();
			// 4.执行具体的SQL语句
			// stmt.execute(sql);
			//String sql = "DELETE FROM person WHERE id=1";
			// 返回结构:受该SQL语句影响的行数.
			int result = stmt.executeUpdate(sql);
			if (result > 0) {
				System.out.println("更新成功!");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			// 5.释放资源
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
