package com.syc.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.junit.Test;

/*
 * Activiti数据库配置
 */
public class ActivitiDemo01 {

	//创建并配置Activiti所必须的数据库.
	@Test
	public void createProcessEngineTest(){
		//创建一个流程引擎的配置对象
		ProcessEngineConfiguration configuration =
					ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
		
		//在创建流程引擎对象之前,需要配置基本的数据库信息
		configuration.setJdbcDriver("com.mysql.jdbc.Driver");
		configuration.setJdbcUrl("jdbc:mysql://localhost:3306/activitidb2?createDatabaseIfNotExist=true"
				+ "&useUnicode=true&characterEncoding=utf8");
		configuration.setJdbcUsername("root");
		configuration.setJdbcPassword("syc");
		//设置数据库中表的生成策略.类似于hibernate中的建表策略.
		configuration.setDatabaseSchemaUpdate("true");
		
		//创建流程引擎对象,是Activiti框架的核心!
		ProcessEngine engine = configuration.buildProcessEngine();
		if(engine!=null){
			System.out.println("Activiti流程引擎创建完毕!");
		}
	}
	
}

