package com.syc.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.Test;

/**
 * 预编译的SQL语句
 * 
 * @类名称:Jdbc06
 * @创建人:SYC
 * @创建时间:2017年7月11日 下午3:30:55
 */
public class Jdbc06 {

	@Test
	public void insertTest() throws Exception {
		Connection conn = JdbcUtil.getConnection();
		// 原始的Statement对象
		// Statement stmt = conn.createStatement();

		// 当参数不想写死的时候,可以通过传参,拼接字符串的形式来达到目的.
		// 利用字符串拼接的形式,是有问题的,可能会造成SQL注入攻击.
		// ?是占位符.
		String sql = "insert into person (pname,sex) values(?,?)";

		//执行预编译SQL语句.优点:提高安全性,防止SQL注入;提高效率.
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		//赋值,给?占的位子上填充内容
		stmt.setString(1, "武松");
		stmt.setString(2, "男");

		//stmt.executeUpdate(sql);
		//这里才是真正的进行SQL语句的执行!
		//注意:不要在这个方法中再次带sql参数!
		int result = stmt.executeUpdate();
		if(result>0){
			System.out.println("添加成功!");
		}
		
		JdbcUtil.close(stmt, conn);
	}
}
