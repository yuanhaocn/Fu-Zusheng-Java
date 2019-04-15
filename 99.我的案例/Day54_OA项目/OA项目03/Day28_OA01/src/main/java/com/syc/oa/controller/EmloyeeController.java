package com.syc.oa.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.syc.oa.domain.TbDept;
import com.syc.oa.domain.TbEmployee;
import com.syc.oa.domain.TbJob;
import com.syc.oa.service.DeptService;
import com.syc.oa.service.EmployeeService;
import com.syc.oa.service.JobService;
import com.syc.oa.vo.PageBean;

@Controller
public class EmloyeeController {

	@Autowired
	private DeptService deptService;
	@Autowired
	private JobService jobService;
	@Autowired
	private EmployeeService employeeService;

	// 跳转到员工信息查询页面
	@RequestMapping("/employee/selectEmployee")
	public String showEmployee(Model model) {
		getDeptAndJob(model);
		return "employee/employee";
	}

	// 查询部门信息和职位信息,存储到Request域
	public void getDeptAndJob(Model model) {
		List<TbDept> deptList = deptService.findAll();
		List<TbJob> jobList = jobService.findAll();
		model.addAttribute("deptList", deptList);
		model.addAttribute("jobList", jobList);
	}

	// 员工信息查询
	@RequestMapping("/ejson")
	@ResponseBody
	public PageBean<TbEmployee> findEmployee(Integer did, Integer jid, String gender, String name, String phone,
			String cardid) {
		Map<String, Object> map = new HashMap<>();
		map.put("did", did);
		map.put("jid", jid);
		map.put("gender", gender);
		map.put("name", name);
		map.put("phone", phone);
		map.put("cardid", cardid);
		return employeeService.selectEmployee(map);
	}

	// 员工添加
	@RequestMapping("/employee/addEmployee")
	public String addEmployee(Integer flag, TbEmployee employee, Model model, HttpServletResponse response)
			throws IOException {
		PrintWriter writer = response.getWriter();
		if (flag == 1) {
			getDeptAndJob(model);
			return "employee/showAddEmployee";
		} else {
			if (employeeService.addEmployee(employee)) {
				writer.print("success");
			}
		}
		return null;
	}

	// 员工编辑
	@RequestMapping("/employee/updateEmployee")
	public String updateEmployee(Integer flag, Integer id, Model model, TbEmployee employee,
			HttpServletResponse response) throws IOException {
		PrintWriter writer = response.getWriter();
		if (flag == 1) {
			model.addAttribute("employee", employeeService.findById(id));
			getDeptAndJob(model);
			return "employee/showUpdateEmployee";
		} else {// 真正的编辑操作
			if (employeeService.updateEmployee(employee)) {
				writer.print("success");
			}
		}
		return null;
	}

	// 员工删除
	@RequestMapping("/employee/removeEmployee")
	public String removeEmployee(Integer flag, Integer id,
			@RequestParam(value = "ids[]", required = false) Integer[] ids) {
		if (flag == 1) {
			employeeService.removeOne(id);
			//重定向的时候,跳转到逻辑视图名无效!
			//return "redirect:employee/employee";
			//重定向的时候,从一个Action跳到另一个Action是可以的.
			return "redirect:/employee/selectEmployee";
		} else {
			employeeService.removeMore(ids);
			return "redirect:/employee/selectEmployee";
		}
	}

	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
}
