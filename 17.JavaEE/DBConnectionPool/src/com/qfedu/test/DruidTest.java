package com.qfedu.test;

import java.sql.Connection;

import org.junit.Test;

import com.qfedu.util.druid.DruidUtil;

public class DruidTest {

	@Test
	public void test() throws Exception {
	 Connection connection = DruidUtil.getConnection();
	 System.out.println(connection);
	}
}


