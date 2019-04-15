package com.syc.dubbo;

import java.io.IOException;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.syc.dubbo.domain.User;
import com.syc.dubbo.service.HelloService;

public class ConsumerTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-dubboconsumer.xml");

		context.start();

		// 得到要引用的服务
		HelloService service = context.getBean("helloService", HelloService.class);

		// 调用远程方法一:
		String sayHello = service.sayHello("阿三");
		System.out.println("返回的信息=" + sayHello);

		// 调用远程方法二:
		List<User> users = service.getUsers();
		for (User user : users) {
			System.out.println("user=" + user.toString());
		}

		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}

		context.close();
	}

}
