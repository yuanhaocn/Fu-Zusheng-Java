package com.syc.freemarker;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class FreemarkerTest {

	@Test
	public void test1(){
		FreemarkerUtil util=new FreemarkerUtil();
		Map<String, Object> model=new HashMap<String, Object>();
		model.put("msg", "Hello,Freemarker!");
		util.showAtConsole("/ftl", "01.ftl", model);
	}
	
	@Test
	public void test2(){
		FreemarkerUtil util=new FreemarkerUtil();
		Map<String, Object> model=new HashMap<String, Object>();
		model.put("msg", "Hello,Freemarker!");
		util.generateFile("/ftl", "01.ftl", "01.txt", model);
	}
	
	@Test
	public void test3(){
		FreemarkerUtil util=new FreemarkerUtil();
		Map<String, Object> model=new HashMap<String, Object>();
		model.put("title", "模板生成的html文件");
		model.put("content", "啦啦啦,我是模板里的内容....");
		util.generateFile("/ftl", "02.ftl", "02.html", model);
	}
	
	@Test
	public void test4(){
		FreemarkerUtil util=new FreemarkerUtil();
		Map<String, Object> model=new HashMap<String, Object>();
		User user=new User("001", "阿三", 33, "女");
		model.put("user", user);
		util.generateFile("/ftl", "03.ftl", "03.html", model);
	}
	
	@Test
	public void test5(){
		FreemarkerUtil util=new FreemarkerUtil();
		Map<String, Object> model=new HashMap<String, Object>();
	
		ArrayList<User> users=new ArrayList<User>();
		users.add(new User("001", "阿三", 33, "男"));
		users.add(new User("002", "三胖", 35, "男"));
		users.add(new User("003", "死呆子", 33, "男"));
		users.add(new User("004", "武大郎", 33, "男"));
		model.put("users", users);
		
		util.generateFile("/ftl", "04.ftl", "04.html", model);
	}
	
	@Test
	public void test6(){
		FreemarkerUtil util=new FreemarkerUtil();
		util.generateFile("/ftl", "05.ftl", "05.html", null);
	}
	
	@Test
	public void test7(){
		FreemarkerUtil util=new FreemarkerUtil();
		Map<String, Object> model=new HashMap<String, Object>();
	
		ArrayList<User> users=new ArrayList<User>();
		users.add(new User("001", "阿三", 33, "男"));
		users.add(new User("002", "三胖", 35, "男"));
		users.add(new User("003", "死呆子", 33, "男"));
		users.add(new User("004", "武大郎", 33, "男"));
		model.put("users", users);
		
		util.generateFile("/ftl", "06.ftl", "06.html", model);
	}
	
	@Test
	public void test8(){
		FreemarkerUtil util=new FreemarkerUtil();
		Map<String, Object> model=new HashMap<String, Object>();
		
		ArrayList<User> users=new ArrayList<User>();
		users.add(new User("001", "阿三", 33, "男",new Date()));
		users.add(new User("002", "三胖", 35, "男",new Date()));
		users.add(new User("003", "死呆子", 33, "男",new Date()));
		users.add(new User("004", "武大郎", 33, "男",new Date()));
		model.put("users", users);
		
		util.generateFile("/ftl", "07.ftl", "07.html", model);
	}
	
	@Test
	public void test9(){
		FreemarkerUtil util=new FreemarkerUtil();
		Map<String, Object> model=new HashMap<String, Object>();
		
		//ArrayList<User> users=new ArrayList<User>();
		/*users.add(new User("001", "阿三", 33, "男",new Date()));
		users.add(new User("002", "三胖", 35, "男",new Date()));
		users.add(new User("003", "死呆子", 33, "男",new Date()));
		users.add(new User("004", "武大郎", 33, "男",new Date()));*/
	
		ArrayList<User> users=null;
		model.put("users", users);
		
		util.generateFile("/ftl", "08.ftl", "08.html", model);
	}
	
	@Test
	public void test10(){
		FreemarkerUtil util=new FreemarkerUtil();
		Map<String, Object> model=new HashMap<String, Object>();
		
		//ArrayList<User> users=new ArrayList<User>();
		/*users.add(new User("001", "阿三", 33, "男",new Date()));
		users.add(new User("002", "三胖", 35, "男",new Date()));
		users.add(new User("003", "死呆子", 33, "男",new Date()));
		users.add(new User("004", "武大郎", 33, "男",new Date()));*/
	
		ArrayList<User> users=null;
		model.put("users", users);
		
		util.generateFile("/ftl", "09.ftl", "09.html", model);
	}
	
	@Test
	public void test11(){
		FreemarkerUtil util=new FreemarkerUtil();
		util.generateFile("/ftl", "10.ftl", "10.html", null);
	}
	
	@Test
	public void test12(){
		FreemarkerUtil util=new FreemarkerUtil();
		HashMap<String, Object> model=new HashMap<String, Object>();
		model.put("ClassName", "Person");
		model.put("id", "id");
		model.put("name", "name");
		util.generateFile("/ftl", "11.ftl", "Person.java", model);
	}
}
