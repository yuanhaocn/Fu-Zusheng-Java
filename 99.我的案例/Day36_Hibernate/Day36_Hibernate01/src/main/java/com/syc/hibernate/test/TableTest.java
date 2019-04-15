package com.syc.hibernate.test;

import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class TableTest {

	@Test
	public void test(){
		//Hibernate提供的配置类,Hibernate会默认去src目录下加载hibernate.cfg.xml配置文件,
		//读取我们关于数据库的配置信息和ORM映射文件.
		Configuration cfg=new Configuration();
		cfg.configure();
		//创建SessionFactory,获取数据库连接
		cfg.buildSessionFactory();
	}
}
