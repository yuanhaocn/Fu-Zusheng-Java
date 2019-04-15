package com.syc.jedis;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

//JedisPool,连接池的使用
public class Demo7 {

	@Test
	public void test1() {
		// 每次都创建新的Jedis对象,效率不高!
		// Jedis jedis=new Jedis("10.11.51.37", 6379);

		// 创建的是Jedis连接池
		JedisPool pool = new JedisPool("10.11.51.37", 6379);
		// 获取Jedis对象
		Jedis jedis = pool.getResource();
		jedis.auth("syc");

		jedis.set("key1", "laala");
		
		String value = jedis.get("key1");
		System.out.println("value="+value);
		
		jedis.close();
		pool.close();
		pool.destroy();
	}

}
