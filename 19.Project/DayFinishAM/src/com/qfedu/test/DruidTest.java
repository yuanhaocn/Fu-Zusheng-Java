package com.qfedu.test;

import java.sql.Connection;

import org.junit.Test;

import com.qfedu.util.DruidUtil;

public class DruidTest {
	@Test
	public void fun01() {
		Connection connection = DruidUtil.getConnection();
		System.out.println(connection);
	}
}
