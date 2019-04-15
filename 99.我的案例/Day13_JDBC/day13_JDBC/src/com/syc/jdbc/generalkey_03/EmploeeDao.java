package com.syc.jdbc.generalkey_03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;
import com.syc.jdbc.JdbcUtil;

public class EmploeeDao {

	@SuppressWarnings("resource")
	public void save(Emploee emp) {

		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = JdbcUtil.getConnection();
			// 部门表的添加语句
			String sql_dept = "insert into dept (dname) values(?)";

			// 员工表的添加语句
			String sql_emp = "insert into emp (ename,deptId) values(?,?)";

			// PreparedStatement stmt = conn.prepareStatement(sql_dept);
			// RETURN_GENERATED_KEYS:返回自动产生的主键
			stmt = conn.prepareStatement(sql_dept, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, emp.getDept().getDname());
			stmt.executeUpdate();
			
			// 获取自动产生的主键,起始就是一个ResultSet
			ResultSet generatedKeys = stmt.getGeneratedKeys();
			int deptId = 0;
			if (generatedKeys.next()) {
				// 得到了部门表的id
				deptId = generatedKeys.getInt(1);
			}

			// 给员工表赋值
			stmt = conn.prepareStatement(sql_emp);
			stmt.setString(1, emp.getEname());
			stmt.setInt(2, deptId);

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt, conn);
		}

	}
}
