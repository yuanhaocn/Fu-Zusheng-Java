package com.syc.jedis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import redis.clients.jedis.Jedis;

//操作zset类型,有序的集合.
public class Demo6 {

	@Test
	public void test1() {
		Jedis jedis = new Jedis("10.11.51.37", 6379);
		jedis.auth("syc");

		Map<String, Double> prices = new HashMap<String, Double>();
		prices.put("pro1", 30.0);
		prices.put("pro2", 80.0);
		prices.put("pro3", 10.0);
		prices.put("pro4", 20.0);
		jedis.zadd("price", prices);

		// 计算集合的size
		Long count = jedis.zcard("price");
		System.out.println("count=" + count);

		// 取出集合中的元素
		Set<String> members = jedis.zrange("price", 0, -1);
		Iterator<String> iterator = members.iterator();
		while (iterator.hasNext()) {
			System.out.println("value=" + iterator.next());
		}

		System.out.println("--------------");
		// 取出价格的前2位
		Set<String> zrevrange = jedis.zrevrange("price", 0, 1);
		Iterator<String> iterator2 = zrevrange.iterator();
		while (iterator2.hasNext()) {
			System.out.println("product=" + iterator2.next());
		}

		jedis.close();
	}

}
