package com.syc.dubbo.service;

import java.util.List;

import com.syc.dubbo.domain.User;

/**
 * 抽取出的核心Service.
 * 注意:消费者中的Service,必须与提供者中的Service包路径一致!
 */
public interface HelloService {

	String sayHello(String msg);
	
	List<User> getUsers();
}
