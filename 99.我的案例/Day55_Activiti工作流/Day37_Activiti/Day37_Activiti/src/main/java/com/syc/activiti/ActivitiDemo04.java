package com.syc.activiti;

import java.util.Date;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.junit.Test;

public class ActivitiDemo04 {

	// 查看Task的流程变量
	@Test
	public void test1() {
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		
		Leave leave=new Leave();
		leave.setId(1L);
		leave.setName("小蓝");
		leave.setDesc("世界那么大,我想去旷课...");
		leave.setDate(new Date());
		
		//设置了流程变量
		engine.getTaskService().setVariable("5002", "leave", leave);
		System.out.println("设置完毕");
	}
	
	//获取流程变量的方法
	@Test
	public void test2() {
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		
		//设置了流程变量
		Leave leave = (Leave) engine.getTaskService().getVariable("5002", "leave");
		System.out.println("id="+leave.getId());
		System.out.println("name="+leave.getName());
		System.out.println("desc="+leave.getDesc());
		System.out.println("date="+leave.getDate());
	}

}
