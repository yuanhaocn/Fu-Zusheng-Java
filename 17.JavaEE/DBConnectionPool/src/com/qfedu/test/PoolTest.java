package com.qfedu.test;

import java.sql.Connection;

import org.junit.Test;

import com.qfedu.util.myDbConnectionPool.MyDatabasePool;

public class PoolTest {

	@Test
	public void test() throws Exception{
		 MyDatabasePool myDatabasePool = new MyDatabasePool();
	for (int i = 0; i <5; i++) {
		Connection connection = myDatabasePool.getConnection();
		System.out.println(connection);
	}
	
	}

}
