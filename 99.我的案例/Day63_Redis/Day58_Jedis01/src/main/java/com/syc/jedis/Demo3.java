package com.syc.jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import redis.clients.jedis.Jedis;

//操作hash类型.
public class Demo3 {

	@Test
	public void test1() {
		Jedis jedis=new Jedis("10.11.51.37", 6379);
		jedis.auth("syc");
		
		jedis.hset("users", "name", "三胖");
		
		String name = jedis.hget("users", "name");
		
		System.out.println("name="+name);
		
		jedis.close();
	}
	
	@Test
	public void test2() {
		Jedis jedis=new Jedis("10.11.51.37", 6379);
		jedis.auth("syc");
		
		Map<String, String> map=new HashMap<String, String>();
		map.put("name", "三胖");
		map.put("age", "38");
		map.put("job", "manager");
		jedis.hmset("user",map);
		
		List<String> list = jedis.hmget("user", "name","job");
		for(String value : list){
			System.out.println("value="+value);
		}
		
		jedis.close();
	}
	
	
}
