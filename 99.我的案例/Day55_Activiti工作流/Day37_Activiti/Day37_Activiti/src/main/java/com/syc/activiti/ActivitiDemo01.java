package com.syc.activiti;

import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.junit.Test;

public class ActivitiDemo01 {

	// 创建流程引擎对象
	@Test
	public void test1() {
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		if (engine != null) {
			System.out.println("流程引擎对象创建成功!");
		}
	}

	// 部署流程
	@Test
	public void test2() {
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		Deployment deploy = engine.getRepositoryService().createDeployment().name("请假申请").category("请假")
				.addClasspathResource("diagrams/leave.bpmn")
				.addClasspathResource("diagrams/leave.png")
				.deploy();// 添加操作.
		System.out.println("流程部署ID=" + deploy.getId());
		System.out.println("流程部署操作=" + deploy.getName());
		System.out.println("流程部署分类=" + deploy.getCategory());
		System.out.println("流程部署时间=" + deploy.getDeploymentTime());
	}

	// 执行流程
	@Test
	public void test3() {
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		RuntimeService service = engine.getRuntimeService();

		// 根据key开启一个流程,得到一个流程实例.
		ProcessInstance instance = service.startProcessInstanceByKey("leaveProcess");

		System.out.println("流程实例ID=" + instance.getProcessDefinitionId());
		System.out.println("流程定义的key=" + instance.getProcessDefinitionKey());
	}

	// 任务查询
	@Test
	public void test4() {
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();

		TaskService service = engine.getTaskService();

		TaskQuery query = service.createTaskQuery();

		List<Task> tasks = query.orderByTaskId().desc().taskAssignee("小李子")// 查询条件
				.list();

		if (tasks != null && tasks.size() > 0) {
			for (Task task : tasks) {
				System.out.println("任务ID=" + task.getId());
				System.out.println("任务名称=" + task.getName());
				System.out.println("任务创建时间=" + task.getCreateTime());
				System.out.println("任务办理人=" + task.getAssignee());
				System.out.println("任务执行对象的id=" + task.getExecutionId());
				System.out.println("任务所在流程的id=" + task.getProcessDefinitionId());
			}
		}
	}
	
	//结束某一个任务
	@Test
	public void test5() {
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();

		TaskService service = engine.getTaskService();
		//结束指定任务id的任务
		service.complete("2504");
		System.out.println("任务结束");
	}

}
