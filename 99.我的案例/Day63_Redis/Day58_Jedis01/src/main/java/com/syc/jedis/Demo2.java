package com.syc.jedis;

import java.util.List;

import org.junit.Test;

import redis.clients.jedis.Jedis;

//操作String类型.
public class Demo2 {

	// 客户端与服务器是否畅通
	@Test
	public void test1() {
		Jedis jedis=new Jedis("10.11.51.37", 6379);
		jedis.auth("syc");
		
		jedis.set("name", "syc");
		//设置过期时间
		jedis.expire("name", 5);
		
		//jedis.setex("name", 5, "syc");
		
		jedis.close();
	}
	
	@Test
	public void test2() {
		Jedis jedis=new Jedis("10.11.51.37", 6379);
		jedis.auth("syc");
		String value = jedis.get("name");
		System.out.println("value="+value);
		jedis.close();
	}
	
	@Test
	public void test3() {
		Jedis jedis=new Jedis("10.11.51.37", 6379);
		jedis.auth("syc");
		
		//注意:如果某个key想要进行自增自减,则该key必须要保证能够转换为Integer类型!
		//jedis.set("age", "01");
		jedis.set("age", "1");
		//默认自增1
		//jedis.incr("age");
		jedis.incrBy("age", 5);

		//jedis.decr(key)
		//jedis.decrBy(key, integer)
		
		String age = jedis.get("age");
		System.out.println("age="+age);
		
		jedis.close();
	}
	
	@Test
	public void test4() {
		Jedis jedis=new Jedis("10.11.51.37", 6379);
		jedis.auth("syc");
		
		//jedis.setnx("name", "yyg1");
		
		//jedis.del("name");
		
		//注意:mset方法中的参数数量应该是偶数,一个key跟一个value!
		jedis.mset("name","syc","age","30");
		
		String name = jedis.get("name");
		String age = jedis.get("age");
		
		System.out.println("name="+name);
		System.out.println("age="+age);
		
		jedis.close();
	}
	
	@Test
	public void test5() {
		Jedis jedis=new Jedis("10.11.51.37", 6379);
		jedis.auth("syc");
		
		//批量取值
		List<String> mget = jedis.mget("name","age");
		
		for(String value : mget){
			System.out.println("value="+value);
		}
		
		jedis.close();
	}
}
