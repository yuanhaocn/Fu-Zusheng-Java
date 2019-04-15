package com.qfedu.test;

import java.sql.Connection;

import org.junit.Test;

import com.qfedu.util.c3p0.C3P0Util;

public class C3p0Test {
	@Test
	public void test() throws Exception {
	 Connection connection = C3P0Util.getConnection();
	 System.out.println(connection);
	}
}
