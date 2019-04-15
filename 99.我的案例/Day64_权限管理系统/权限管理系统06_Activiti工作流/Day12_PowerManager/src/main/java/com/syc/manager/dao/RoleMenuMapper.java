package com.syc.manager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface RoleMenuMapper {

	void addRoleMenu(@Param("roleId") Integer roleId, @Param("menuIdList") List<Integer> menuIdList);

	List<Integer> findMenuByRoleId(Integer roleId);

	void deleteRoleMenuById(Integer roleId);
	
	void deleteRoleMenuByMenuId(Integer menuId);

}
