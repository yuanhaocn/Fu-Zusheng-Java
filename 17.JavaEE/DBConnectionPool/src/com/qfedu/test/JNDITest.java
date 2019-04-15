package com.qfedu.test;

import java.sql.Connection;

import org.junit.Test;

import com.qfedu.util.jndi.JNDIUtil;

public class JNDITest {
@Test
public void test() throws Exception{
	Connection connection = JNDIUtil.getConnection();
	System.out.println(connection);
}
}
