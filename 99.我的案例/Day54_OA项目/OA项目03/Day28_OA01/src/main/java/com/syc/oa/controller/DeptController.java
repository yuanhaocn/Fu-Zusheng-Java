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

import com.syc.oa.domain.TbDept;
import com.syc.oa.service.DeptService;
import com.syc.oa.vo.PageBean;

/**
 * 部门管理模块
 */
@Controller
public class DeptController {

	@Autowired
	private DeptService service;

	// 跳转到部门查询页面
	@RequestMapping("/dept/selectDept")
	public String showDept() {
		return "dept/dept";
	}

	// 部门查询
	@RequestMapping("/djson")
	@ResponseBody
	public PageBean<TbDept> findDept(@RequestParam(defaultValue = "") String deptName) {

		return service.findDept(deptName);
	}

	// 部门添加
	@RequestMapping("/dept/addDept")
	public String addDept(Integer flag, TbDept dept, HttpServletResponse response) throws IOException {
		PrintWriter writer = response.getWriter();
		if (flag == 1) {// 跳转
			return "dept/showAddDept";
		} else {
			if (service.addDept(dept)) {
				writer.print("success");
			}
		}
		return null;
	}

	//部门编辑
	@RequestMapping("/dept/updateDept")
	public String updateDept(Integer flag,Integer id,TbDept dept,Model model,HttpServletResponse response) throws IOException{
		PrintWriter writer = response.getWriter();
		if(flag==1){//跳转
			model.addAttribute("dept", service.findById(id));
			return "dept/showUpdateDept";
		}else{//真正的修改操作
			if(service.updateDept(dept)){
				writer.print("success");
			}
		}
		return null;
	}
	
	// 部门删除
	@RequestMapping("/dept/removeDept")
	public String removeDept(Integer flag, Integer id, @RequestParam(value = "ids[]", required = false) Integer[] ids) {
		if(flag==1){//单个删除
			service.removeOne(id);
			return "dept/dept";
		}else{//批量删除
			service.removeMore(ids);
			return "dept/dept";
		}
	}
}
