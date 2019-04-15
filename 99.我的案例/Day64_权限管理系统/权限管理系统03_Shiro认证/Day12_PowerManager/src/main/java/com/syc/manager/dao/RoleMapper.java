package com.syc.manager.dao;

import java.util.List;

import com.syc.manager.domain.Role;

public interface RoleMapper {

	List<String> getUserRoleList(Integer userId);

	List<Role> getAllRoles();
}
