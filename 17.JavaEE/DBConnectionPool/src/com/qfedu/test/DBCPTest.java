package com.qfedu.test;

import java.sql.Connection;

import org.junit.Test;

import com.qfedu.util.dbcp.DBCPUtil;

public class DBCPTest {

	@Test
	public void test() throws Exception {
	 Connection connection = DBCPUtil.getConnection();
	 System.out.println(connection);
	}
}
