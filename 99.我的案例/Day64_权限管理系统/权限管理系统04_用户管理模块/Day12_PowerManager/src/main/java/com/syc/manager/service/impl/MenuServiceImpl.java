package com.syc.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syc.manager.dao.MenuMapper;
import com.syc.manager.dao.RoleMenuMapper;
import com.syc.manager.domain.Menu;
import com.syc.manager.service.MenuService;
import com.syc.manager.vo.Perms;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuMapper menuMapper;
	
	@Autowired
	private RoleMenuMapper roleMenuMapper;
	
	@Override
	public List<String> getUserPermissionsList(Integer userId) {

		return menuMapper.getUserPermissionsList(userId);
	}

	@Override
	public List<Perms> findAllUrlPerms() {

		return menuMapper.findAllUrlPerms();
	}

	@Override
	public List<Menu> getAllMenuForTree() {

		return menuMapper.getAllMenu();
	}

	@Override
	public List<Integer> findMenuByRoleId(Integer roleId) {

		return roleMenuMapper.findMenuByRoleId(roleId);
	}

}
