package com.syc.utils.queryrunner04;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import com.syc.utils.JdbcUtil;

public class QueryRunnerBatch {

	@Test
	public void batchInsert() {
		Connection conn = JdbcUtil.getConnection();
		String sql = "insert into user (username,password) values(?,?)";
		
		//注意参数的写法:
		Object[][] params=new Object[][]{{"李斯","444"},{"赵高","555"}};
		
		try {
			QueryRunner qr = new QueryRunner();
			//批处理
			qr.batch(conn, sql, params);
			
			DbUtils.close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void batchDelete() {
		Connection conn = JdbcUtil.getConnection();
		String sql = "delete from user where username=?";
		
		//注意参数的写法:
		Object[][] params=new Object[][]{{"李斯"},{"赵高"}};
		
		try {
			QueryRunner qr = new QueryRunner();
			//批处理
			//result返回还是受影响的行数.
			int[] result = qr.batch(conn, sql, params);
			System.out.println(result.length);
			
			DbUtils.close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
