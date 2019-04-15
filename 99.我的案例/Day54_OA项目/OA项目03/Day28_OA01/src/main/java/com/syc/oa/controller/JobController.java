package com.syc.oa.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.syc.oa.domain.TbJob;
import com.syc.oa.service.JobService;
import com.syc.oa.vo.PageBean;

/**
 * 职位管理模块
 */
@Controller
public class JobController {

	@Autowired
	private JobService service;

	// 跳转到职位查询页面
	@RequestMapping("/job/selectJob")
	public String showJob() {
		return "job/job";
	}

	// 部门查询
	@RequestMapping("/jobJson")
	@ResponseBody
	public PageBean<TbJob> findJob(@RequestParam(defaultValue = "") String jobName) {

		return service.findJob(jobName);
	}

	// 职位添加
	@RequestMapping("/job/addJob")
	public String addJob(Integer flag, TbJob job, HttpServletResponse response) throws IOException {
		PrintWriter writer = response.getWriter();
		if (flag == 1) {// 跳转
			return "job/showAddJob";
		} else {
			if (service.addJob(job)) {
				writer.print("success");
			}
		}
		return null;
	}

	//职位编辑
	@RequestMapping("/job/updateJob")
	public String updateJob(Integer flag,Integer id,TbJob job,Model model,HttpServletResponse response) throws IOException{
		PrintWriter writer = response.getWriter();
		if(flag==1){//跳转
			model.addAttribute("job", service.findById(id));
			return "job/showUpdateJob";
		}else{//真正的修改操作
			if(service.updateJob(job)){
				writer.print("success");
			}
		}
		return null;
	}
	
	// 职位删除
	@RequestMapping("/job/removeJob")
	public String removeJob(Integer flag, Integer id, @RequestParam(value = "ids[]", required = false) Integer[] ids) {
		if(flag==1){//单个删除
			service.removeOne(id);
			return "job/job";
		}else{//批量删除
			service.removeMore(ids);
			return "job/job";
		}
	}
}
