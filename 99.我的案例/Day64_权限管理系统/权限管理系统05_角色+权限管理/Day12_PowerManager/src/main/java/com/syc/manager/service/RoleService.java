package com.syc.manager.service;

import java.sql.SQLException;
import java.util.List;

import com.syc.manager.domain.Role;
import com.syc.manager.vo.PageBean;

public interface RoleService {

	List<String> getUserRoleList(Integer userId);
	
	List<Role> getAllRoles();

	PageBean<Role> findAllRoles(int i, Integer limit);

	void addRole(Role role) throws SQLException;

	Role findRoleById(Integer roleId);

	void deleteRole(Integer[] ids)  throws SQLException;

	void updateRole(Role role);

}
