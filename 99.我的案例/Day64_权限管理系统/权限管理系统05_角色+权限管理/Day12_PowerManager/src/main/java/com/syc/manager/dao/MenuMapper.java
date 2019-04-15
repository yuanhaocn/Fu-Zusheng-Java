package com.syc.manager.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.syc.manager.domain.Menu;
import com.syc.manager.vo.Perms;

public interface MenuMapper {

	List<String> getUserPermissionsList(Integer userId);

	List<Perms> findAllUrlPerms();

	List<Menu> getAllMenu();

	void addMenu(Menu menu) throws SQLException;

	Menu findMenuById(Integer menuId) throws SQLException;

	void updateMenu(@Param("menu") Menu menu);

	void deleteMenu(@Param("ids") Integer[] ids) throws SQLException;
}
