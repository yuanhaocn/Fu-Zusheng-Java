package com.syc.pool.c3p0;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Demo {

	// 2种C3P0的配置方式
	@Test
	public void c3p0Demo1() {
		try {
			// 创建数据源对象
			ComboPooledDataSource source = new ComboPooledDataSource();
			// 进行各种配置
			// 加载驱动程序
			source.setDriverClass("com.mysql.jdbc.Driver");
			// 设置url
			source.setJdbcUrl("jdbc:mysql://localhost:3306/db01");
			// 设置用户名
			source.setUser("root");
			// 设置密码
			source.setPassword("syc");
			// 设置初始的连接池大小.
			source.setInitialPoolSize(20);
			// 连接池的最大值
			source.setMaxPoolSize(50);
			// 设置连接对象的最大空闲时间,某个连接对象如果3秒内一直空闲,则释放其资源.
			source.setMaxIdleTime(3000);
			// 设置某个连接的最大生命周期.
			// source.setMaxConnectionAge(2000);

			// 获取数据库连接对象
			Connection conn = source.getConnection();
			String sql = "insert into person (pname,sex) values('钢蛋','女')";
			PreparedStatement stmt = conn.prepareStatement(sql);
			int result = stmt.executeUpdate();
			if (result > 0) {
				System.out.println("添加成功!");
			}
			conn.close();
		} catch (SQLException | PropertyVetoException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void c3p0Demo2() {
		try {
			// 默认就会去src下加载c3p0-config.xml文件.
			//1.new ComboPooledDataSource();
			//2.在ComboPooledDataSource()方法内部默认去加载src去加载c3p0-config.xml文件;
			//props.load(is);
			//3.进行XML解析.
			//4.读取出xml中的配置信息之后,赋值给source.setXXX()方法.
			ComboPooledDataSource source = new ComboPooledDataSource();
			Connection conn = source.getConnection();
			
			String sql = "insert into person (pname,sex) values('铁蛋','男')";
			PreparedStatement stmt = conn.prepareStatement(sql);
			int result = stmt.executeUpdate();
			if (result > 0) {
				System.out.println("添加成功!");
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void c3p0Demo3() {
		try {
			Connection conn = C3P0Util.getConnection();
			
			String sql = "insert into person (pname,sex) values('铜蛋','女')";
			PreparedStatement stmt = conn.prepareStatement(sql);
			int result = stmt.executeUpdate();
			if (result > 0) {
				System.out.println("添加成功!");
			}
		
			C3P0Util.close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
