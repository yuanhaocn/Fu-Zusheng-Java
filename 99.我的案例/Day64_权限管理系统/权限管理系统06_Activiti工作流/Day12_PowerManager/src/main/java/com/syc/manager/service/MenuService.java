package com.syc.manager.service;

import java.sql.SQLException;
import java.util.List;

import com.syc.manager.domain.Menu;
import com.syc.manager.vo.PageBean;
import com.syc.manager.vo.Perms;

public interface MenuService {

	List<String> getUserPermissionsList(Integer userId);

	List<Perms> findAllUrlPerms();

	List<Menu> getAllMenuForTree();

	List<Integer> findMenuByRoleId(Integer roleId);

	PageBean<Menu> findAllMenu(int pageNum, Integer pageSize);

	void addMenu(Menu menu) throws SQLException;

	Menu findMenuById(Integer menuId) throws SQLException;

	void updateMenu(Menu menu);

	void removeMenu(Integer[] ids) throws SQLException;
}
