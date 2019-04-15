package com.syc.jdbc.batch_01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.syc.jdbc.JdbcUtil;

public class UserDao {

	public void save(List<User> users) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "insert into user (username,password) values(?,?)";
			stmt = conn.prepareStatement(sql);
			for (User usr : users) {
				// 给参数赋值
				stmt.setString(1, usr.getUsername());
				stmt.setString(2, usr.getPassword());

				// 将数据添加到批处理的"箱子"里.
				stmt.addBatch();
				
				//同时insert,delete,update
				//注意:此时的SQL的结构是不同的;SQL中不能有?占位符.
				//要使用普通的Statement对象.
				//String insertSql="insert....";
				//String deleteSql="delete....";
				//String updateSql="update....";
				//stmt.addBatch(insertSql);
				//stmt.addBatch(deleteSql);
				//stmt.addBatch(updateSql);
			}

			// 执行批处理:注意:是一次性完成.
			stmt.executeBatch();

			// 清空批处理操作
			stmt.clearBatch();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt, conn);
		}
	}
}
