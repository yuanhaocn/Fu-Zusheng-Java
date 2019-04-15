package com.syc.manager.service;

import java.util.List;

import com.syc.manager.domain.Role;

public interface RoleService {

	List<String> getUserRoleList(Integer userId);
	
	List<Role> getAllRoles();

}
