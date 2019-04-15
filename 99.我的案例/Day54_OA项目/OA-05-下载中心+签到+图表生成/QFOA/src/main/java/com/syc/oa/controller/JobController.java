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
	private JobService jobService;

	/**
	 * 跳转到职位查询页面
	 */
	@RequestMapping("/job/selectJob")
	public String showJob() {
		return "job/job";
	}

	/**
	 * 添加职位
	 */
	@RequestMapping("/job/addJob")
	public String addJob(Integer flag, TbJob job, HttpServletResponse response) throws IOException {
		PrintWriter writer = response.getWriter();
		if (flag == 1) {
			return "job/showAddJob";
		} else {
			if (jobService.addJob(job)) {
				writer.print("success");
			}
			return null;
		}
	}

	// 注意:要保证方法中的参数名称和前端一致!
	// 比如name参数,需要和jsp页面中的ajax上传给服务器,及从服务器接收过来绑定的数据字段
	// 都要一致,否则可能导致后端接收不到前端传递过来的数据.
	@ResponseBody
	@RequestMapping("/jobJson")
	public PageBean<TbJob> findJob(@RequestParam(defaultValue = "") String name) {
		return jobService.findJob(name);
	}
	
	/**
	 * 编辑职位
	 */
	@RequestMapping("/job/updateJob")
	public String editJob(Integer flag, Integer id, TbJob job, Model model, HttpServletResponse response)
			throws IOException {
		PrintWriter printWriter = response.getWriter();
		if (flag == 1) {
			model.addAttribute("job", jobService.findJobById(id));
			return "job/showUpdateJob";
		} else {
			if (jobService.updateJob(job)) {
				printWriter.print("success");
			}
			return null;
		}
	}

	/**
	 * 移除职位
	 */
	@RequestMapping("/job/removeJob")
	public String removeJob(Integer flag, Integer id, @RequestParam(value = "ids[]", required = false) Integer[] ids) {
		if (flag == 1) {
			jobService.removeOneJob(id);
			return "job/job";
		} else {
			jobService.removeMore(ids);
			return "job/job";
		}
	}

}
