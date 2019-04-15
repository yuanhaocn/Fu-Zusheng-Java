package com.syc.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.junit.Test;

/*
 * Activiti数据库配置
 */
public class ActivitiDemo02 {

	// 创建并配置Activiti所必须的数据库.
	@Test
	public void createProcessEngineTest() {
		// 创建一个流程引擎的配置对象
		ProcessEngineConfiguration configuration = 
				ProcessEngineConfiguration
				.createProcessEngineConfigurationFromResource("activiti.cfg.xml");

		ProcessEngine engine = configuration.buildProcessEngine();
		
		if (engine != null) {
			System.out.println("Activiti流程引擎创建完毕!");
		}
	}

}
