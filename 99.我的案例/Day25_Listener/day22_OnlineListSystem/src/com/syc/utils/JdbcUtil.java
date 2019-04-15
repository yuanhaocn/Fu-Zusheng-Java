package com.syc.utils;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * JDBC连接工具类
 * 
 * @author 一一哥
 * @Description:
 */
public class JdbcUtil {

	private static ComboPooledDataSource source;

	// 获取数据源
	static {
		source = new ComboPooledDataSource();
	}

	//获取QueryRunner对象
	public static QueryRunner getQueryRunner() {
		return  new QueryRunner(source);
	}
}
