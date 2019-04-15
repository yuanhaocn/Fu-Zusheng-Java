package com.qfedu.util.druid;

import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;


public class DruidUtil {
	public static Connection getConnection() throws Exception{
		// 构建property对象，加载配置文件
		Properties properties = new Properties();
		properties.load(new FileInputStream(
				"C://Users//FZS//eclipse-workspace//Day16AM//src//com//qfedu//util//druid//druid.properties"));

		DataSource dataSource=DruidDataSourceFactory.createDataSource(properties);
		Connection connection = dataSource.getConnection();
		return connection;
	}
}
