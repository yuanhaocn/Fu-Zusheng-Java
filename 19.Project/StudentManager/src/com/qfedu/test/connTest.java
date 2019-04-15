package com.qfedu.test;

import java.sql.Connection;

import org.junit.Test;

import com.qfedu.util.DButil;

public class connTest {

	@Test
	public void test() {
		 Connection connection = DButil.getConnection();
		 System.out.println(connection);
	}

}
