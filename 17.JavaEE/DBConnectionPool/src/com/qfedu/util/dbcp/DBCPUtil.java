package com.qfedu.util.dbcp;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class DBCPUtil {
	public static Connection getConnection() throws Exception, IOException {
		// 构建property对象，加载配置文件
		Properties properties = new Properties();
		properties.load(new FileInputStream("C://Users//FZS//eclipse-workspace//Day16AM//src//com//qfedu//util//dbcp//dbcp.properties"));
		// 2.构建基本数据源工厂,创建数据源对象
		BasicDataSource dataSource = BasicDataSourceFactory.createDataSource(properties);
		//3.通过DataSource对象获取连接对象
		Connection connection = dataSource.getConnection();
		return connection;
	}
}
