package com.syc.manager.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.syc.manager.domain.Role;

public interface RoleMapper {

	List<String> getUserRoleList(Integer userId);

	List<Role> getAllRoles();

	void addRole(Role role) throws SQLException;

	Role findRoleById(Integer roleId);

	void deleteRole(@Param("ids") Integer[] ids);

	void updateRole(@Param("role") Role role);

}
