package com.syc.spring.jdbc02;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

/*
 * 模拟JdbcTemplate类的实现.
 */
public class DataSourceTemplate {

	private DataSource source;

	public DataSource getSource() {
		return source;
	}

	public void setSource(DataSource source) {
		this.source = source;
	}

	public int update(String sql) {
		try {
			Connection conn = source.getConnection();
			Statement stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);
			stmt.close();
			conn.close();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
