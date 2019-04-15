package com.syc.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.junit.Test;

/*
 * Activiti数据库配置
 */
public class ActivitiDemo03 {

	// 创建并配置Activiti所必须的数据库.
	@Test
	public void createProcessEngineTest() {
		
		//获取默认的流程引擎对象.它会去默认的路径下,去匹配加载activiti.cfg.xml文件.
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		
		if (engine != null) {
			System.out.println("Activiti流程引擎创建完毕!");
		}
	}

}
