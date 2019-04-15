package com.syc.jedis;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class Demo1 {

	// 客户端与服务器是否畅通
	@Test
	public void test1() {
		// 创建单机版的Jedis对象
		Jedis jedis = new Jedis("10.11.51.37", 6379);
		//保护模式的异常解决:1.protected mode no;2.requirepass "syc";
		//requirepass "syc"
		//redis.clients.jedis.exceptions.JedisDataException:
		//NOAUTH Authentication required.
		jedis.auth("syc");
		String code = jedis.ping();
		System.out.println("响应=" + code);
		jedis.quit();
		jedis.close();
		
	}
}
