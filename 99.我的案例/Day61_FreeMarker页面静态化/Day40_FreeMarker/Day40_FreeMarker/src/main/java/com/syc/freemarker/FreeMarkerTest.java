package com.syc.freemarker;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class FreeMarkerTest {

	@Test
	public void test1() {
		FreeMarkerUtil util = new FreeMarkerUtil();
		Map<String, Object> dataModel = new HashMap<String, Object>();
		dataModel.put("hello", "Hello,FreeMarker,学不会的都是笨蛋!");
		util.printToConsole("/ftl", "01.ftl", dataModel);
	}

	@Test
	public void test2() {
		FreeMarkerUtil util = new FreeMarkerUtil();
		Map<String, Object> dataModel = new HashMap<String, Object>();
		dataModel.put("hello", "Hello,FreeMarker,学不会的都是笨蛋!");
		// 利用FreeMarker可以生成txt,html,jsp,xml等.
		util.printToFile("/ftl", "01.ftl", dataModel, "01.txt");
	}

	@Test
	public void test3() {
		FreeMarkerUtil util = new FreeMarkerUtil();
		Map<String, Object> dataModel = new HashMap<String, Object>();
		dataModel.put("hello", "Hello,FreeMarker,学不会的都是笨蛋!");
		// 利用FreeMarker可以生成txt,html,jsp,xml等.
		util.printToFile("/ftl", "02.ftl", dataModel, "02.html");
	}

	@Test
	public void test4() {
		FreeMarkerUtil util = new FreeMarkerUtil();

		Map<String, Object> dataModel = new HashMap<String, Object>();
		User user = new User();
		user.setId(1);
		user.setAge(30);
		user.setHeight(180.0f);
		user.setName("李大锤");
		dataModel.put("user", user);

		// 利用FreeMarker可以生成txt,html,jsp,xml等.
		util.printToFile("/ftl", "03.ftl", dataModel, "03.html");
	}

	@Test
	public void test5() {
		FreeMarkerUtil util = new FreeMarkerUtil();

		Map<String, Object> dataModel = new HashMap<String, Object>();

		// 利用FreeMarker可以生成txt,html,jsp,xml等.
		util.printToFile("/ftl", "04.ftl", dataModel, "04.html");
	}

	@Test
	public void test6() {
		FreeMarkerUtil util = new FreeMarkerUtil();

		Map<String, Object> dataModel = new HashMap<String, Object>();

		List<User> users = new ArrayList<User>();

		User user1 = new User();
		user1.setId(1);
		user1.setAge(20);
		user1.setHeight(180.0f);
		user1.setName("李大锤");

		User user2 = new User();
		user2.setId(2);
		user2.setAge(38);
		user2.setHeight(170.0f);
		user2.setName("马大锤");

		User user3 = new User();

		user3.setId(3);
		user3.setAge(10);
		user3.setHeight(100.0f);
		user3.setName("大锤");

		users.add(user1);
		users.add(user2);
		users.add(user3);

		dataModel.put("users", users);

		// 利用FreeMarker可以生成txt,html,jsp,xml等.
		util.printToFile("/ftl", "05.ftl", dataModel, "05.html");
	}

	@Test
	public void test7() {
		FreeMarkerUtil util = new FreeMarkerUtil();

		Map<String, Object> dataModel = new HashMap<String, Object>();

		List<User> users = new ArrayList<User>();

		User user1 = new User();
		user1.setId(1);
		user1.setAge(20);
		user1.setHeight(180.0f);
		user1.setName("李大锤");

		User user2 = new User();
		user2.setId(2);
		user2.setAge(38);
		user2.setHeight(170.0f);
		user2.setName("马大锤");

		User user3 = new User();

		user3.setId(3);
		user3.setAge(10);
		user3.setHeight(100.0f);
		user3.setName("大锤");

		users.add(user1);
		users.add(user2);
		users.add(user3);

		dataModel.put("users", users);

		// 利用FreeMarker可以生成txt,html,jsp,xml等.
		util.printToFile("/ftl", "06.ftl", dataModel, "06.html");
	}

	@Test
	public void test8() {
		FreeMarkerUtil util = new FreeMarkerUtil();

		Map<String, Object> dataModel = new HashMap<String, Object>();

		List<User> users = new ArrayList<User>();

		User user1 = new User();
		user1.setId(1);
		user1.setAge(20);
		user1.setHeight(180.0f);
		user1.setName("李大锤");
		user1.setBirthday(new Date());

		User user2 = new User();
		user2.setId(2);
		user2.setAge(38);
		user2.setHeight(170.0f);
		user2.setName("马大锤");
		user2.setBirthday(new Date());

		User user3 = new User();

		user3.setId(3);
		user3.setAge(10);
		user3.setHeight(100.0f);
		user3.setName("大锤");
		user3.setBirthday(new Date());

		users.add(user1);
		users.add(user2);
		users.add(user3);

		dataModel.put("users", users);

		// 利用FreeMarker可以生成txt,html,jsp,xml等.
		util.printToFile("/ftl", "07.ftl", dataModel, "07.html");
	}

	@Test
	public void test9() {
		FreeMarkerUtil util = new FreeMarkerUtil();

		Map<String, Object> dataModel = new HashMap<String, Object>();

		// User user = new User();
		// user.setId(3);
		// user.setAge(10);
		// user.setHeight(100.0f);
		// user.setName("大锤");
		// user.setBirthday(new Date());
		
		User user=null;

		dataModel.put("user", user);

		// 利用FreeMarker可以生成txt,html,jsp,xml等.
		util.printToFile("/ftl", "08.ftl", dataModel, "08.html");
	}
	
	@Test
	public void test10() {
		FreeMarkerUtil util = new FreeMarkerUtil();
		
		Map<String, Object> dataModel = new HashMap<String, Object>();

		User user=null;

		dataModel.put("user", user);
		
		// 利用FreeMarker可以生成txt,html,jsp,xml等.
		util.printToFile("/ftl", "09.ftl", dataModel, "09.html");
	}
	
	@Test
	public void test11() {
		FreeMarkerUtil util = new FreeMarkerUtil();
		
		Map<String, Object> dataModel = new HashMap<String, Object>();
		
		// 利用FreeMarker可以生成txt,html,jsp,xml等.
		util.printToFile("/ftl", "10.ftl", dataModel, "10.html");
	}
}
