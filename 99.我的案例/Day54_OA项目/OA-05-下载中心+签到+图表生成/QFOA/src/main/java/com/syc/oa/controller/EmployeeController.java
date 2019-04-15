package com.syc.oa.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

/**
 * 员工管理模块
 */
@Controller
public class EmployeeController {

	@Autowired
	private DeptService deptService;
	@Autowired
	private JobService jobService;
	@Autowired
	private EmployeeService employeeService;

	/**
	 * 跳转到员工管理
	 */
	@RequestMapping("/employee/selectEmployee")
	public String showEmployee(Model model) {
		// 获取部门和职位,为前端下拉框准备数据支持
		getJobAndDept(model);
		// 返回视图
		return "employee/employee";
	}

	/**
	 * 获取职位和部门信息
	 */
	public void getJobAndDept(Model model) {
		// 获取所有部门
		List<TbDept> deptList = deptService.findAll();
		// 获取所有职位
		List<TbJob> jobList = jobService.findAll();
		// 添加到session中,为前端的下拉框提供数据支持
		model.addAttribute("deptList", deptList);
		model.addAttribute("jobList", jobList);
	}

	/**
	 * 查找员工信息
	 */
	@ResponseBody
	@RequestMapping("/employeeJson")
	public PageBean<TbEmployee> employeeJson(Integer jid, Integer did, @RequestParam(defaultValue = "") String name,
			@RequestParam(defaultValue = "") String cardId, @RequestParam(defaultValue = "") String phone,
			@RequestParam(defaultValue="") String gender) {
		Map<String, Object> map = new HashMap<>(16);
		map.put("jid", jid);
		map.put("did", did);
		map.put("name", name);
		map.put("cardId", cardId);
		map.put("phone", phone);
		map.put("gender", gender);
		return employeeService.selectEmployee(map);
	}

	/**
	 * 添加员工
	 */
	@RequestMapping("/employee/addEmployee")
	public String addEmployee(Integer flag, Model model, TbEmployee employee, Integer jid, Integer did,
			HttpServletResponse response) throws IOException {
		
		PrintWriter writer = response.getWriter();
		// 判断请求类型,如果flag=1.则是跳转到添加页面,如果是flag=2,则是保存employee
		if (flag == 1) {
			getJobAndDept(model);
			return "employee/showAddEmployee";
		} else {
			if (employeeService.addEmployee(employee, jid, did)) {
				writer.print("success");
			}
			return null;
		}
	}

	/**
	 * 编辑员工信息
	 */
	@RequestMapping("/employee/updateEmployee")
	public String updateEmployee(Integer flag, Integer id, Model model, TbEmployee employee, Integer jid, Integer did,
			HttpServletResponse response) throws IOException {
		PrintWriter writer = response.getWriter();
		if (flag == 1) {
			model.addAttribute("employee", employeeService.selectEmployeeById(id));
			getJobAndDept(model);
			return "employee/showUpdateEmployee";
		} else {
			if (employeeService.updateEmployee(employee, jid, did)) {
				writer.print("success");
			}
			return null;
		}
	}

	/**
	 * 删除员工
	 */
	@RequestMapping("/employee/removeEmployee")
	public String removeEmployee(Integer flag, Integer id,
			@RequestParam(value = "ids[]", required = false) Integer[] ids) {
		if (flag == 1) {
			employeeService.removeOne(id);
			return "redirect:/employee/selectEmployee";
		} else {
			employeeService.removeMore(ids);
			return "redirect:/employee/selectEmployee";
		}
	}

}
