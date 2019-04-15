package com.qfedu.test;

import java.sql.Connection;

import org.junit.Test;

import com.qfedu.util.C3P0Util;

public class ConnTest {
	@Test
	public void fun01() {
		Connection connection = C3P0Util.getConnection();
		System.out.println(connection);
	}
}
