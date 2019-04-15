package com.syc.jdbc.transaction_04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

import org.junit.Test;

import com.syc.jdbc.JdbcUtil;

public class DbTransaction {

	@SuppressWarnings("resource")
	@Test
	public void transactionTest() {

		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql_sub = "update acount set money=money-1000 where username=?";
			String sql_add = "update1 acount set money=money+1000 where username=?";

			// Connection默认就已经开启了事务.
			// 是否自动提交事务----->事务的提交相当于事物的关闭
			// 1.设置事务自动提交关闭
			conn.setAutoCommit(false);

			// 第一次执行:执行减钱的操作
			stmt = conn.prepareStatement(sql_sub);
			stmt.setString(1, "三胖");
			stmt.executeUpdate();

			// 第二次执行:执行加钱的操作
			stmt = conn.prepareStatement(sql_add);
			stmt.setString(1, "四呆");
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			// 2.事务的回滚
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			JdbcUtil.close(stmt, conn);
			// 3.手动提交事务.
			try {
				conn.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@SuppressWarnings("resource")
	@Test
	public void transactionTest2() {

		Connection conn = null;
		PreparedStatement stmt = null;
		Savepoint sp=null;
		try {
			//给第一个人转账的语句
			String sql_sub1 = "update acount set money=money-1000 where username=?";
			String sql_add1 = "update acount set money=money+1000 where username=?";
			
			//给第2个人转账的语句
			String sql_sub2 = "update acount set money=money-500 where username=?";
			String sql_add2 = "update1 acount set money=money+500 where username=?";
			
			conn = JdbcUtil.getConnection();
			
			//1.关闭事务自动提交功能
			conn.setAutoCommit(false);
			
			//给第一个人的转账操作
			stmt = conn.prepareStatement(sql_sub1);
			stmt.setString(1, "三胖");
			stmt.executeUpdate();
			stmt=conn.prepareStatement(sql_add1);
			stmt.setString(1, "四呆");
			stmt.executeUpdate();
			
			//2.设置保存点
			sp = conn.setSavepoint();
			
			//给第2个人的转账操作
			stmt = conn.prepareStatement(sql_sub2);
			stmt.setString(1, "三胖");
			stmt.executeUpdate();
			stmt=conn.prepareStatement(sql_add2);
			stmt.setString(1, "四呆");
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				//3.设置回滚
				//conn.rollback();
				//回滚到某个保存点
				conn.rollback(sp);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				//4.提交事务
				conn.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			JdbcUtil.close(stmt, conn);
		}
	}
}
