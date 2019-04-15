package com.syc.pool.dbcp;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

public class DBCPDemo {

	@Test
	public void demo1() {
		// 建立一个数据源
		BasicDataSource source = new BasicDataSource();

		source.setDriverClassName("com.mysql.jdbc.Driver");
		source.setUrl("jdbc:mysql://localhost:3306/db01");
		source.setUsername("root");
		source.setPassword("syc");

		// 设置连接池初始的数量
		source.setInitialSize(10);
		// 连接池最大数量
		source.setMaxActive(30);
		// 最大空闲时间
		source.setMaxIdle(3000);

		try {
			Connection conn = source.getConnection();

			String sql = "select * from person";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString("pname");
				System.out.println("Name=" + name);
			}

			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void demo2() {
		try {
			// 加载配置文件
			Properties props = new Properties();
			InputStream is = DBCPDemo.class.getResourceAsStream("db.properties");
			props.load(is);
			// 利用BasicDataSourceFactory来创建DataSource对象
			DataSource source = BasicDataSourceFactory.createDataSource(props);
			
			//利用数据源对象得到Connection
			Connection conn = source.getConnection();
			String sql = "select * from person";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString("pname");
				System.out.println("Name=" + name);
			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
