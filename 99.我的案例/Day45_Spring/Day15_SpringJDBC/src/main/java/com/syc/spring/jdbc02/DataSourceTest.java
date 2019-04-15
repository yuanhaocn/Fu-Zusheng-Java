package com.syc.spring.jdbc02;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DataSourceTest {

	@Test
	public void test1(){
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("beans01.xml");
		
		DataSourceTemplate bean = context.getBean("template",DataSourceTemplate.class);
		String sql="update person set name='傻狗' where id=17";
		int update = bean.update(sql);
		if(update>0){
			System.out.println("更新成功!");
		}
		
		context.close();
	}
	
	@Test
	public void test2(){
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("beans01.xml");
		
		PersonDao dao = context.getBean("dao",PersonDao.class);
		String sql="update person set name='小狗' where id=17";
		int update = dao.update(sql);
		if(update>0){
			System.out.println("更新成功!");
		}
		
		context.close();
	}
}
