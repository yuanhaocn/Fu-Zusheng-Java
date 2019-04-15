package com.syc.manager.service.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.syc.manager.dao.RoleMapper;
import com.syc.manager.dao.RoleMenuMapper;
import com.syc.manager.domain.Role;
import com.syc.manager.service.RoleService;
import com.syc.manager.util.MyLog;
import com.syc.manager.util.ShiroUtils;
import com.syc.manager.vo.PageBean;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;

	@Autowired
	private RoleMenuMapper roleMenuMapper;

	@Override
	public List<String> getUserRoleList(Integer userId) {
		return roleMapper.getUserRoleList(userId);
	}

	@Override
	public List<Role> getAllRoles() {

		return roleMapper.getAllRoles();
	}

	@Override
	public PageBean<Role> findAllRoles(int currentPage, Integer pageSize) {
		PageHelper.startPage(currentPage, pageSize);
		List<Role> roles = roleMapper.getAllRoles();
		PageInfo<Role> info = new PageInfo<>(roles);
		long total = info.getTotal();
		return new PageBean<>(total, roles);
	}

	@Override
	public void addRole(Role role) throws SQLException {
		if (role != null) {
			role.setCreateTime(new Date());
			role.setCreateUserId(ShiroUtils.getUser().getUserId());
			MyLog.log("service--->name=" + role.getRoleName());
			roleMapper.addRole(role);

			// 级联添加role_menu表
			List<Integer> menuIdList = role.getMenuIdList();
			if (menuIdList != null && menuIdList.size() != 0) {
				roleMenuMapper.addRoleMenu(role.getRoleId(), menuIdList);
			}
		}
	}

	@Override
	public void updateRole(Role role) {
		// 修改role表
		roleMapper.updateRole(role);

		// 级联删除role_menu表中原有的角色-权限记录
		roleMenuMapper.deleteRoleMenuById(role.getRoleId());

		// 级联添加新的role_menu表的角色-权限记录
		List<Integer> menuIdList = role.getMenuIdList();
		if (menuIdList != null && menuIdList.size() != 0) {
			roleMenuMapper.addRoleMenu(role.getRoleId(), menuIdList);
		}
	}

	@Override
	public Role findRoleById(Integer roleId) {

		return roleMapper.findRoleById(roleId);
	}

	@Override
	public void deleteRole(Integer[] ids) throws SQLException {

		roleMapper.deleteRole(ids);

		// 级联删除对应的角色权限role_menu表的记录
		for (int i = 0; i < ids.length; i++) {
			roleMenuMapper.deleteRoleMenuById(ids[i]);
		}
	}

}
