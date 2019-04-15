package com.syc.jedis;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

//Redis集群
public class Demo8 {

	@SuppressWarnings("deprecation")
	@Test
	public void test1() {
		// 创建服务器节点
		Set<HostAndPort> nodes = new HashSet<HostAndPort>();
		nodes.add(new HostAndPort("10.11.51.37", 7001));
		nodes.add(new HostAndPort("10.11.51.37", 7002));
		nodes.add(new HostAndPort("10.11.51.37", 7003));
		nodes.add(new HostAndPort("10.11.51.37", 7004));
		nodes.add(new HostAndPort("10.11.51.37", 7005));
		nodes.add(new HostAndPort("10.11.51.37", 7006));
		
		// 创建Jedis集群对象
		JedisCluster cluster = new JedisCluster(nodes);
		cluster.auth("syc");
		cluster.set("clusterKey", "集群...");
		String value = cluster.get("clusterKey");
		System.out.println("value=" + value);
		Map<String, JedisPool> clusterNodes = cluster.getClusterNodes();
		for (Map.Entry<String, JedisPool> entry : clusterNodes.entrySet()) {
			System.out.println("key=" + entry.getKey());
			System.out.println("value=" + entry.getValue());
		}
		// cluster.flushAll();
		try {
			cluster.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
