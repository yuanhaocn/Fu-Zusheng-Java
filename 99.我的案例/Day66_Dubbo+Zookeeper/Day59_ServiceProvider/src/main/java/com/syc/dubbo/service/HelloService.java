package com.syc.dubbo.service;

import java.util.List;

import com.syc.dubbo.domain.User;

/**
 * 抽取出的核心Service
 */
public interface HelloService {

	String sayHello(String msg);
	
	List<User> getUsers();
}
