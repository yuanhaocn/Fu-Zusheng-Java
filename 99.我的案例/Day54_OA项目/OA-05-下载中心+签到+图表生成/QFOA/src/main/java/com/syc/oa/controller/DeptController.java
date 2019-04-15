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
 * 部门管理模块.
 */
@Controller
public class DeptController {

	@Autowired
	private DeptService deptService;

	/**
	 * 跳转到部门管理
	 */
	@RequestMapping("/dept/selectDept")
	public String showDept() {
		return "dept/dept";
	}

	/**
	 * 部门查询
	 */
	@ResponseBody
	@RequestMapping("/deptJson")
	public PageBean<TbDept> findDept(@RequestParam(defaultValue = "") String deptName) {
		return deptService.findDept(deptName);
	}

	/**
	 * 添加部门
	 */
	@RequestMapping("/dept/addDept")
	public String addDep(Integer flag, TbDept dept, HttpServletResponse response) throws IOException {
		PrintWriter writer = response.getWriter();
		if (flag == 1) {
			return "dept/showAddDept";
		} else {
			if (deptService.addDept(dept)) {
				writer.print("success");
			}
			return null;
		}
	}

	/**
	 * 编辑部门
	 */
	@RequestMapping("/dept/updateDept")
	public String updateDept(Integer flag, Integer id, TbDept dept, Model model, HttpServletResponse response)
			throws IOException {
		PrintWriter writer = response.getWriter();
		if (flag == 1) {
			model.addAttribute("dept", deptService.findDeptById(id));
			return "dept/showUpdateDept";
		} else {
			if (deptService.editDept(dept)) {
				writer.print("success");
			}
			return null;
		}
	}

	/**
	 * 移除部门
	 */
	@RequestMapping("/dept/removeDept")
	public String removeDept(Integer flag, Integer id, @RequestParam(value = "ids[]", required = false) Integer[] ids) {
		if (flag == 1) {
			deptService.removeOneDept(id);
			return "dept/dept";
		} else {
			deptService.removeMore(ids);
			return "dept/dept";
		}
	}

}
