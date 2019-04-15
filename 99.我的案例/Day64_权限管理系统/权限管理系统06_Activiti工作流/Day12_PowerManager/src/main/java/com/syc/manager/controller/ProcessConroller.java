package com.syc.manager.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.syc.manager.domain.MyTask;
import com.syc.manager.domain.TaskBean;
import com.syc.manager.service.UserService;
import com.syc.manager.util.JSONUtil;
import com.syc.manager.util.ShiroUtils;
import com.syc.manager.vo.BaseJSON;
import com.syc.manager.vo.PageBean;

/**
 * 流程管理的控制器
 * 
 * @类名称:ProcessConroller
 * @创建人:一一哥
 * @创建时间:2018年3月19日 上午10:53:26
 */
@Controller
public class ProcessConroller {

	@Autowired
	private UserService userService;

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private TaskService taskService;

	/**
	 * 跳转到请假界面
	 */
	@RequestMapping(value = "/user/task/open", params = { "leave" })
	public String showLeave(Model model) {
		model.addAttribute("title", "填写请假流程:");
		model.addAttribute("url", "/user/task/doStart.action");
		model.addAttribute("key", "leave");
		model.addAttribute("label_1", "请假人姓名:");
		model.addAttribute("label_2", "部门领导:");
		model.addAttribute("label_3", "请假时间:");
		model.addAttribute("label_4", "请假原因:");
		model.addAttribute("username", ShiroUtils.getUserName());

		model.addAttribute("userNameList", userService.getManagerNameList());

		return "user/leave";
	}

	/**
	 * 跳转到借款界面
	 */
	@RequestMapping(value = "/user/task/open", params = { "borrow" })
	public String showBorrow(Model model) {
		model.addAttribute("title", "填写请假流程:");
		model.addAttribute("url", "/user/task/doStart.action");
		model.addAttribute("key", "borrow");
		model.addAttribute("label_1", "借款人姓名:");
		model.addAttribute("label_2", "部门领导:");
		model.addAttribute("label_3", "借款金额:");
		model.addAttribute("label_4", "借款原因:");
		model.addAttribute("username", ShiroUtils.getUserName());

		model.addAttribute("userNameList", userService.getManagerNameList());

		return "user/borrow";
	}

	/**
	 * 实现员工请假流程
	 */
	@ResponseBody
	@RequestMapping(value = "/user/task/doStart", produces = { "text/plain;charset=UTF-8" })
	public String doStart(String key, TaskBean task) {
		// 流程变量
		Map<String, Object> variables = new HashMap<>();
		variables.put("user", task.getAssignee());
		variables.put("task", task);
		// 根据key来开启一个流程实例
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(key, variables);

		// 开启一个流程
		TaskQuery taskQuery = taskService.createTaskQuery();
		// 根据流程id,执行该流程
		String taskId = taskQuery.executionId(processInstance.getId()).singleResult().getId();

		// 指定当前任务属于哪个人
		taskService.setOwner(taskId, ShiroUtils.getUserName());

		// 结束当前任务
		taskService.complete(taskId, variables);

		return JSONUtil.objectToJson(BaseJSON.setOK("处理成功!"));
	}

	/************************* 以下是manager身份的员工,处理待办事项 ***************************/
	/**
	 * 跳转到待办事项
	 */
	@RequestMapping("/manager/task/index")
	public String showTodoThing() {

		return "task/index";
	}

	/**
	 * 查询当前manager所有的待办事项
	 */
	@ResponseBody
	@RequestMapping("/manager/task/list")
	public String showTasks(Integer offset, Integer limit) {
		PageHelper.startPage(offset / limit + 1, limit);

		TaskQuery taskQuery = taskService.createTaskQuery();
		String assignee = ShiroUtils.getUserName();
		// 设置经办人作为过滤条件
		List<Task> list = taskQuery.taskAssignee(assignee).list();

		List<MyTask> myTasks = new ArrayList<>();
		for (Task task : list) {
			MyTask mTask = new MyTask();
			mTask.setId(task.getId());
			mTask.setAssignee(task.getAssignee());
			mTask.setCreateTime(task.getCreateTime());
			mTask.setDescription(task.getDescription());
			mTask.setCategory(task.getCategory());
			mTask.setName(task.getName());
			mTask.setOwner(task.getOwner());
			myTasks.add(mTask);
		}

		PageInfo<MyTask> info = new PageInfo<>(myTasks);
		long total = info.getTotal();
		PageBean<MyTask> bean = new PageBean<>(total, myTasks);

		return JSONUtil.objectToJson(bean);
	}

	/**
	 * 查看任务详情,跳转到任务详情界面 manager身份的人才可以处理的方法!
	 */
	@RequestMapping("/manager/task/view")
	public String showView(String id, Model model) {
		// TaskBean bean = (TaskBean) taskService.getVariable(id, "task");
		TaskBean bean = taskService.getVariable(id, "task", TaskBean.class);
		model.addAttribute("taskInfo", bean);
		model.addAttribute("id", id);
		model.addAttribute("key", bean.getKey());

		if ("borrow".equals(bean.getKey())) {// 借款
			model.addAttribute("name", "借款人姓名:");
			model.addAttribute("money", "借款金额:");
			model.addAttribute("reason", "借款原因:");
		} else {// 请假
			model.addAttribute("name", "请假人姓名:");
			model.addAttribute("money", "请假时间:");
			model.addAttribute("reason", "请假原因:");
		}

		List<String> userNameList = userService.getManagerNameList();
		model.addAttribute("userNameList", userNameList);

		return "task/view";
	}

	/**
	 * 进行下一步的任务审核
	 */
	@ResponseBody
	@RequestMapping(value = "/manager/task/doNextTask", produces = { "text/plain;charset=UTF-8" })
	public String doNextTask(String id, String assignee) {
		TaskBean bean = taskService.getVariable(id, "task", TaskBean.class);
		
		//注意:要在complete()方法之前调用!
		Task task = taskService.createTaskQuery().taskId(id).singleResult();
		
		Map<String, Object> variables=new HashMap<>();
		variables.put("task", bean);
		variables.put("user", assignee);
		//重新设置流程变量
		taskService.complete(id, variables);
		
		//将两次Task任务进行对比,根据对比结果,判断审核是否最终结束!
		Task nextTask = taskService.createTaskQuery().taskId(task.getId()).singleResult();
		if(nextTask==null){//如果没有下一个任务了,则意味着整个的任务审核完成!
			return JSONUtil.objectToJson(BaseJSON.setOK("审批完成!"));
		}
	
		return JSONUtil.objectToJson(BaseJSON.setOK("正在审批中,请耐心等待..."));
	}
}
