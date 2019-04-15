package com.syc.jedis;

import java.util.List;

import org.junit.Test;

import redis.clients.jedis.Jedis;

//操作list类型.
public class Demo4 {

	@Test
	public void test1() {
		Jedis jedis=new Jedis("10.11.51.37", 6379);
		jedis.auth("syc");
		
		//lpush中的l表示left,操作的是栈结构!
		jedis.lpush("product1", "{'id':'001','name':'手机','price':300$}","{'id':'002','name':'电视','price':400$}");
		
		//取出对应的值,并且从栈中删掉该值!
		//jedis.lpop("product");
		
		//-1表示返回整个list集合中的所有元素.
		List<String> list = jedis.lrange("product", 0, -1);
		for(String msg : list){
			System.out.println("msg="+msg);
		}
		
		jedis.close();
	}
	
	@Test
	public void test2() {
		Jedis jedis=new Jedis("10.11.51.37", 6379);
		jedis.auth("syc");
		
		//rpush中的r是right,操作的是队列!
		jedis.rpush("product2", "{'id':'001','name':'手机','price':300$}","{'id':'002','name':'电视','price':400$}");
		
		List<String> list = jedis.lrange("product2", 0,-1);
		for(String msg : list){
			System.out.println("msg="+msg);
		}
		
		jedis.close();
	}
	
	
}
