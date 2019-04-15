package com.syc.activiti;

import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.junit.Test;

public class ActivitiDemo03 {

	// 查看历史流程信息
	@Test
	public void test1() {
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		List<HistoricProcessInstance> list = engine.getHistoryService()
				.createHistoricProcessInstanceQuery()// 历史流程实例信息查询
				.list();

		for (HistoricProcessInstance instance : list) {
			System.out.println("历史流程id=" + instance.getId());
			System.out.println("历史流程定义的id=" + instance.getProcessDefinitionId());
			System.out.println("历史流程定义的key=" + instance.getProcessDefinitionKey());
			System.out.println("历史流程的开始时间=" + instance.getStartTime());
			System.out.println("历史流程的结束时间=" + instance.getEndTime());
		}
	}

	// 查看历史任务信息
	@Test
	public void test2() {
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		List<HistoricTaskInstance> list = engine.getHistoryService()
			.createHistoricTaskInstanceQuery()//查询历史任务信息
			.list();

		for (HistoricTaskInstance instance : list) {
			System.out.println("历史流程id=" + instance.getId());
			System.out.println("历史流程定义的id=" + instance.getProcessDefinitionId());
			System.out.println("历史任务名称=" + instance.getName());
			System.out.println("历史任务分类=" + instance.getCategory());
			System.out.println("历史任务办理人=" + instance.getAssignee());
		}
	}

}
