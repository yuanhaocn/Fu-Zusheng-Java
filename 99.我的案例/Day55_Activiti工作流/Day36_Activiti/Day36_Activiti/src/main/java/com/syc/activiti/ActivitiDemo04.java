package com.syc.activiti;

import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.junit.Test;

/*
 * Activiti的流程定义及操作
 */
public class ActivitiDemo04 {

	// 部署Activiti流程.
	@Test
	public void deployProcessTest() {
		// 获取流程引擎对象
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();

		// 获取一个仓库服务组件,管理流程定义.
		// 注意:在Activiti中,基本上获取XXXService,就差不多相当于操作XXX这种表!
		RepositoryService service = engine.getRepositoryService();

		// 对流程部署做各种设置,获取一个部署对象
		Deployment deployment = service.createDeployment().name("采购申请").category("采购")
				.addClasspathResource("diagrams/buy.bpmn")
				.addClasspathResource("diagrams/buy.png")
				.deploy();// 执行deploy()方法的时候.相当于是往re_deployment表中添加信息.

		System.out.println("流程部署的ID=" + deployment.getId());
		System.out.println("流程部署的Name=" + deployment.getName());
		System.out.println("流程部署的Category=" + deployment.getCategory());
		System.out.println("流程部署的部署时间=" + deployment.getDeploymentTime());
	}

	// 执行流程
	@Test
	public void startProcessTest() {
		// 获取流程引擎对象
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();

		// 获取一个运行时对象
		RuntimeService service = engine.getRuntimeService();
		// 根据XXX开启流程实例的方法
		// service.startProcessInstanceByXXX(processDefinitionId)
		// 设置流程变量的方法
		// service.setVariableXXX(executionId, variableName, value);
		// 获取流程变量的方法
		// service.getVariableXXX(executionId, variableName)
		// 获取当前正在执行的流程任务的查询信息
		// service.createExecutionQueryXXX();
		// 删除相关流程信息
		// service.deleteGroupIdentityLink(processInstanceId, groupId,
		// identityLinkType);

		// 根据key,开启一个流程实例.
		ProcessInstance instance = service.startProcessInstanceByKey("buyProcess");
		System.out.println("流程ID=" + instance.getId());
		// 流程定义ID由三部分来组成,buyProcess:1:2504
		System.out.println("流程定义ID=" + instance.getProcessDefinitionId());
		System.out.println("流程定义的Key=" + instance.getProcessDefinitionKey());
	}

	// 开启流程实例的查询
	@Test
	public void startProcessQueryTest() {
		// 获取流程引擎对象
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();

		// 获取一个运行时对象
		RuntimeService service = engine.getRuntimeService();

		// 获取一个流程实例查询
		ProcessInstanceQuery query = service.createProcessInstanceQuery();
		// 获取表中的数量
		// long count = query.count();
		// System.out.println("count="+count);

		List<ProcessInstance> list = query.list();
		for (ProcessInstance instance : list) {
			System.out.print("流程ID=" + instance.getId());
			System.out.print("流程定义ID=" + instance.getProcessDefinitionId());
			System.out.print("流程定义的Key=" + instance.getProcessDefinitionKey());
			System.out.println();
		}
	}

	// 查询Task任务信息
	@Test
	public void taskQueryTest() {
		// 获取流程引擎对象
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();

		// 获取一个Task服务对象
		TaskService service = engine.getTaskService();
		// 设置办理人
		// service.setAssignee(taskId, userId);

		TaskQuery query = service.createTaskQuery();
		// taskAssignee:指明办理人的名称
		List<Task> list = query.taskAssignee("小赵").list();
		for (Task task : list) {
			System.out.println("task办理人=" + task.getAssignee());
			System.out.println("task的id=" + task.getId());
			System.out.println("task的name=" + task.getName());
		}
	}

	// 完成Task任务信息
	@Test
	public void completeQueryTest() {
		// 获取流程引擎对象
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();

		// 获取一个Task服务对象
		TaskService service = engine.getTaskService();
		// 设置办理人
		// service.setAssignee(taskId, userId);

		TaskQuery query = service.createTaskQuery();
		// taskAssignee:指明办理人的名称
		List<Task> list = query.taskAssignee("小赵").list();
		for (Task task : list) {
			//完成当前任务
			service.complete(task.getId());
			System.out.println("当前任务执行完毕!");
		}
	}
}
