package com.syc.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.junit.Test;

/**
 * 调用存储过程
 * 
 * @类名称:Jdbc08
 * @创建人:SYC
 * @创建时间:2017年7月12日 上午10:15:27
 */
public class Jdbc08 {

	@Test
	public void callProcedure() {
		Connection conn = null;
		CallableStatement stmt = null;
		try {
			conn = JdbcUtil.getConnection();
			
			// 调用存储过程的SQL语句
			String sql = "CALL pro_findById(?)";
			// 执行存储过程的预编译的Statement
			stmt = conn.prepareCall(sql);
			
			stmt.setInt(1, 1);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString("username");
				String pwd = rs.getString("password");
				System.out.println("Name=" + name + ",Pass=" + pwd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt, conn);
		}
	}
	
	@Test
	public void callProcedureWithOut() {
		Connection conn = null;
		CallableStatement stmt = null;
		try {
			conn = JdbcUtil.getConnection();
			
			String sql="CALL pro_findResult(?,?)";
			stmt=conn.prepareCall(sql);
			
			//指定第一个参数的值
			stmt.setInt(1, 1);
			//注册输出参数,第二个参数是用来指明输出参数的类型.
			stmt.registerOutParameter(2, Types.CHAR);
			
			stmt.executeQuery();
			
			//获取输出参数的内容
			String name = stmt.getString(2);
			System.out.println("Name="+name);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt, conn);
		}
	}
}
