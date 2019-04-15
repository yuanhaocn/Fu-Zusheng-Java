package com.syc.jedis;

import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

import redis.clients.jedis.Jedis;

//操作set类型,无序的集合.
public class Demo5 {

	@Test
	public void test1() {
		Jedis jedis = new Jedis("10.11.51.37", 6379);
		jedis.auth("syc");

		jedis.sadd("set1", "1", "2", "3");

		Set<String> members = jedis.smembers("set1");
		Iterator<String> iterator = members.iterator();

		while (iterator.hasNext()) {
			System.out.println("value=" + iterator.next());
		}

		jedis.close();
	}

	@Test
	public void test2() {
		Jedis jedis = new Jedis("10.11.51.37", 6379);
		jedis.auth("syc");

		jedis.sadd("set1", "1", "2", "3");
		jedis.sadd("set2", "1", "2", "3","4");

		//取交集
		//Set<String> members = jedis.sinter("set1","set2");
		
		//取并集
		//Set<String> members = jedis.sunion("set1","set2");
		
		//判断集合的不同点,以前面的集合为标准!
		//Set<String> members = jedis.sdiff("set1","set2");
		Set<String> members = jedis.sdiff("set2","set1");
		
		//删除集合中的某个元素
		//jedis.srem("set1", "1");
		
		Iterator<String> iterator = members.iterator();
		while (iterator.hasNext()) {
			System.out.println("value=" + iterator.next());
		}
		
		jedis.close();
	}

}
