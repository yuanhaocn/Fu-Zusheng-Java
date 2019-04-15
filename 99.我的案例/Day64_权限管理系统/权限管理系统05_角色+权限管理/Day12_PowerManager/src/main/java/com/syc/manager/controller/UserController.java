package com.syc.manager.controller;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.syc.manager.domain.Role;
import com.syc.manager.domain.User;
import com.syc.manager.service.RoleService;
import com.syc.manager.service.UserService;
import com.syc.manager.util.JSONUtil;
import com.syc.manager.util.PasswordUtil;
import com.syc.manager.util.ShiroUtils;
import com.syc.manager.vo.BaseJSON;
import com.syc.manager.vo.PageBean;
import com.syc.manager.vo.ResponseStatus;

/**
 * 用户管理模块
 * 
 * @类名称:UserController
 * @创建人:一一哥
 * @创建时间:2018年3月15日 上午9:29:45
 */
@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@RequestMapping("/sys/user/index")
	public String showSysUsers() {

		return "sys/user/index";
	}

	/**
	 * 查询user表
	 */
	@ResponseBody
	@RequestMapping("/sys/user/findAllUser")
	public String findAllUsers(Integer offset, Integer limit) {
		PageBean<User> bean = userService.findAllUsers(offset / limit + 1, limit);
		if (bean != null) {
			return JSONUtil.objectToJson(bean);
		}
		return null;
	}

	/**
	 * 跳转到新增用户界面 sys/user/form?add
	 */
	@RequestMapping(value = "/sys/user/form", params = { "add" })
	public String showAddUser(Model model) {
		model.addAttribute("title", "添加用户");
		model.addAttribute("url", "/sys/user/addUser.action");
		User user = new User();
		user.setStatus(1);
		model.addAttribute("user", user);

		// 管理添加用的角色
		List<Role> roles = roleService.getAllRoles();
		model.addAttribute("roleList", roles);

		return "sys/user/form";
	}

	/**
	 * 实现新增用户
	 */
	@ResponseBody
	@RequestMapping(value = "/sys/user/addUser", produces = { "text/plain;charset=UTF-8" })
	public String addUser(User user) {
		BaseJSON json = null;
		if (user != null) {
			user.setCreateTime(new Date());
			user.setCreateUserId(ShiroUtils.getUser().getUserId());
			user.setPassword(PasswordUtil.md5(user.getPassword(), user.getUsername()));

			userService.addUser(user);
			json = BaseJSON.setOK("添加成功!");
		} else {
			json = BaseJSON.setError(ResponseStatus.ERROR, "网络异常,请检查你的网络!");
		}

		return JSONUtil.objectToJson(json);
	}

	/**
	 * 跳转到用户修改界面
	 */
	@RequestMapping(value = "/sys/user/form", params = { "edit" })
	public String showUpdateUser(Integer userId, Model model) {
		User user = userService.findUserById(userId);
		model.addAttribute("title", "修改用户");
		model.addAttribute("url", "/sys/user/updateUser.action");
		model.addAttribute("user", user);

		// 展示所有的角色列表
		List<Role> roles = roleService.getAllRoles();
		model.addAttribute("roleList", roles);

		// 获取用户自身的角色信息
		List<String> userRoles = roleService.getUserRoleList(userId);
		model.addAttribute("userRoleList", userRoles);

		return "sys/user/form";
	}

	/**
	 * 实现真正的修改用户功能
	 */
	@ResponseBody
	@RequestMapping(value="/sys/user/updateUser",produces = { "text/plain;charset=UTF-8" })
	public String updateUser(User user) {
		if (user.getPassword() != null) {
			user.setPassword(PasswordUtil.md5(user.getPassword(), user.getUsername()));
		}

		BaseJSON json = null;
		try {
			userService.updateUser(user);
			json = BaseJSON.setOK("修改成功!");
		} catch (SQLException e) {
			e.printStackTrace();
			json=BaseJSON.setError(ResponseStatus.ERROR, "网络异常,请检查你的网络!");
		}

		return JSONUtil.objectToJson(json);
	}
	
	/**
	 * 实现删除功能
	 */
	@ResponseBody
	@RequestMapping(value="/sys/user/delete",produces = { "text/plain;charset=UTF-8" })
	public String deleteUser(@RequestBody Integer[] ids){
		BaseJSON json = null;
		try {
			userService.deleteUser(ids);
			json = BaseJSON.setOK("删除成功!");
		} catch (SQLException e) {
			e.printStackTrace();
			json=BaseJSON.setError(ResponseStatus.ERROR, "网络异常,请检查你的网络!");
		}

		return JSONUtil.objectToJson(json);
	}

}
