package com.syc.dubbo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.syc.dubbo.domain.User;
import com.syc.dubbo.service.HelloService;

/**
 * 服务的具体实现类
 */
public class HelloServiceImpl implements HelloService {

	public String sayHello(String name) {

		return name + ",你好,我是你大爷!";
	}

	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();

		Random random = new Random();
		int count = random.nextInt(100);
		for (int i = 0; i < count; i++) {
			users.add(new User(i, "user-" + i, (random.nextBoolean() ? "男" : "女")));
		}
		
		return users;
	}

}
