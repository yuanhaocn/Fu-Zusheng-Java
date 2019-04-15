package com.syc.manager.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.syc.manager.dao.MenuMapper;
import com.syc.manager.dao.RoleMenuMapper;
import com.syc.manager.domain.Menu;
import com.syc.manager.service.MenuService;
import com.syc.manager.vo.PageBean;
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

	@Override
	public PageBean<Menu> findAllMenu(int pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Menu> menus = menuMapper.getAllMenu();
		PageInfo<Menu> info = new PageInfo<>(menus);
		return new PageBean<>(info.getTotal(), menus);
	}

	@Override
	public void addMenu(Menu menu) throws SQLException {
		if (menu != null) {
			menu.setParentId(menu.getParentMenu().getMenuId());
			menuMapper.addMenu(menu);
		}
	}

	@Override
	public Menu findMenuById(Integer menuId) throws SQLException {

		return menuMapper.findMenuById(menuId);
	}

	@Override
	public void updateMenu(Menu menu) {
		if (menu != null) {
			menu.setParentId(menu.getParentMenu().getMenuId());
			menuMapper.updateMenu(menu);
		}
	}

	@Override
	public void removeMenu(Integer[] ids) throws SQLException {
		
		menuMapper.deleteMenu(ids);

		// 级联删除role_menu表中的相关记录
		for (int i = 0; i < ids.length; i++) {
			roleMenuMapper.deleteRoleMenuByMenuId(ids[i]);
		}
	}

}
