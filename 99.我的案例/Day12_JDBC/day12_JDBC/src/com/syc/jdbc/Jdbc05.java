package com.syc.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

public class Jdbc05 {

	@Test
	public void queryTest() throws Exception {
		Connection conn = JdbcUtil.getConnection();
		Statement stmt = conn.createStatement();
		String sql="SELECT id, pname,sex FROM person";
		//执行查询语句,返回值ResultSet,就是结果集.
		//Cursor游标
		ResultSet rs = stmt.executeQuery(sql);
		if(rs!=null){
			while(rs.next()){
				//注意:在ResultSet中,下标索引从1开始.
				//int id = rs.getInt(1);
				//String name = rs.getString(1);
				//String sex = rs.getString(2);
				//System.out.println("ID="+id+",Name="+name+",Sex="+sex);
				
				//根据列名得到列的值.
				int id = rs.getInt("id");
				String name = rs.getString("pname");
				String sex = rs.getString("sex");
				System.out.println("ID="+id+",Name="+name+",Sex="+sex);
			}
		}
		
		JdbcUtil.close(stmt, conn, rs);
	}
}
