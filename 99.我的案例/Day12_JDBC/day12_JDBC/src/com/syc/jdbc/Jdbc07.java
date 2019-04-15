package com.syc.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

/**
 * 模拟SQL注入
 * 
 * @类名称:Jdbc07
 * @创建人:SYC
 * @创建时间:2017年7月12日 上午9:27:10
 */
public class Jdbc07 {

	@Test
	public void sqlTest() {
		String name = "四胖 ' or 1=1 -- ";
		String pwd = "222 ' or 1=1 -- ";

		Connection conn = null;
		Statement stmt = null;
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.createStatement();
			// String sql = "select * from user where username='三胖' and
			// password='111'";
			String sql = "select * from user where username='" + name + "' and password='" + pwd + "'";
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				System.out.println("登陆成功!");
			} else {
				System.out.println("登陆失败!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt, conn);
		}
	}

	@Test
	public void sqlTest2() {
		String name = "四胖 ' or 1=1 -- ";
		String pwd = "222 ' or 1=1 -- ";

		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = JdbcUtil.getConnection();
			// String sql = "select * from user where username='三胖' and
			// password='111'";
			String sql = "select * from user where username=? and password=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, pwd);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				System.out.println("登陆成功!");
			} else {
				System.out.println("登陆失败!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt, conn);
		}
	}
}
