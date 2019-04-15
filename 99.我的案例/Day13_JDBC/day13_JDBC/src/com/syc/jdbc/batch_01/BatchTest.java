package com.syc.jdbc.batch_01;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class BatchTest {

	@Test
	public void batchTest() {

		//封装集合
		List<User> users = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			User usr = new User();
			usr.setUsername("Tom" + i);
			usr.setPassword("100" + i);
			users.add(usr);
		}
		
		//批量添加数据
		UserDao dao=new UserDao();
		dao.save(users);
	}
}
