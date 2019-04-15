package com.syc.manager.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.syc.manager.domain.Role;
import com.syc.manager.service.MenuService;
import com.syc.manager.service.RoleService;
import com.syc.manager.util.JSONUtil;
import com.syc.manager.util.MyLog;
import com.syc.manager.vo.BaseJSON;
import com.syc.manager.vo.PageBean;
import com.syc.manager.vo.ResponseStatus;

/**
 * 角色管理
 * 
 * @类名称:RoleController
 * @创建人:一一哥
 * @创建时间:2018年3月16日 上午9:01:48
 */
@Controller
public class RoleController {

	@Autowired
	private RoleService roleService;

	@Autowired
	private MenuService menuService;

	@RequestMapping("/sys/role/index")
	public String showRoleManager() {

		return "sys/role/index";
	}

	/**
	 * 所有角色的查询
	 */
	@ResponseBody
	@RequestMapping("/sys/role/findAllRole")
	public String findAllRoles(Integer offset, Integer limit) {
		PageBean<Role> bean = roleService.findAllRoles(offset / limit + 1, limit);
		if (bean != null) {
			return JSONUtil.objectToJson(bean);
		}
		return null;
	}

	/**
	 * 跳转到添加角色的界面
	 */
	@RequestMapping(value = "/sys/role/form", params = { "add" })
	public String showAddRoles(Model model) {
		model.addAttribute("title", "添加角色");
		model.addAttribute("flag", "add");
		model.addAttribute("role", new Role());

		// List<Role> roles = roleService.getAllRoles();
		// model.addAttribute("roleList", roles);

		return "sys/role/form";
	}

	/**
	 * 添加角色
	 */
	@ResponseBody
	@RequestMapping(value = "/sys/role/addRole", produces = { "text/plain;charset=UTF-8" })
	public String addRoles(@RequestBody Role role) {
		BaseJSON json = null;
		try {
			MyLog.log("rolname=" + role.getRoleName());
			roleService.addRole(role);
			json = BaseJSON.setOK("添加成功!");
		} catch (SQLException e) {
			e.printStackTrace();
			json = BaseJSON.setError(ResponseStatus.ERROR, "网络异常,请检查你的网络!");
		}
		return JSONUtil.objectToJson(json);
	}

	/**
	 * 注意:需要先实现info.action方法,否则会导致编辑界面中,用户的角色信息无法显示!
	 */
	@ResponseBody
	@RequestMapping(value = "/sys/role/info", produces = { "text/plain;charset=UTF-8" })
	public String showRoleInfo(Integer roleId) {
		Role role = roleService.findRoleById(roleId);
		List<Integer> menuIdList = menuService.findMenuByRoleId(roleId);
		role.setMenuIdList(menuIdList);
		return JSONUtil.objectToJson(BaseJSON.setOK(role));
	}

	/**
	 * 跳转到编辑角色的界面
	 */
	@RequestMapping(value = "/sys/role/form", params = { "edit" })
	public String showUpdateRoles(Integer roleId, Model model) {
		model.addAttribute("title", "编辑角色");
		model.addAttribute("flag", "edit");

		Role role = roleService.findRoleById(roleId);
		model.addAttribute("role", role);
		model.addAttribute("roleId", roleId);

		return "sys/role/form";
	}

	/**
	 * 实现角色修改
	 */
	@ResponseBody
	@RequestMapping(value = "/sys/role/updateRole", produces = { "text/plain;charset=UTF-8" })
	public String updateRole(@RequestBody Role role) {
		if (role != null) {
			roleService.updateRole(role);
			return JSONUtil.objectToJson(BaseJSON.setOK("修改成功!"));
		} else {
			return JSONUtil.objectToJson(BaseJSON.setError(ResponseStatus.ERROR, "数据为空!"));
		}
	}

	/**
	 * 删除角色
	 */
	@ResponseBody
	@RequestMapping(value = "/sys/role/delete", produces = { "text/plain;charset=UTF-8" })
	public String removeRole(@RequestBody Integer[] ids) {
		BaseJSON json = null;
		try {
			roleService.deleteRole(ids);
			json = BaseJSON.setOK("删除成功!");
		} catch (SQLException e) {
			e.printStackTrace();
			json = BaseJSON.setError(ResponseStatus.ERROR, "请检查网络");
		}
		return JSONUtil.objectToJson(json);
	}

}
