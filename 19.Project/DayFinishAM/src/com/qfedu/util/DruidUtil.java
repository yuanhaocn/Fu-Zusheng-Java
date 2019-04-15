package com.qfedu.util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;


public class DruidUtil {
	public static Connection getConnection(){
		// 构建property对象，加载配置文件
		Properties properties = new Properties();
		Connection connection=null;
		try {
			properties.load(new FileInputStream("C://Users//FZS//eclipse-workspace//DayFinishAM//src//com//qfedu//util//druid.properties"));
			DataSource dataSource=DruidDataSourceFactory.createDataSource(properties);
			connection = dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}

 