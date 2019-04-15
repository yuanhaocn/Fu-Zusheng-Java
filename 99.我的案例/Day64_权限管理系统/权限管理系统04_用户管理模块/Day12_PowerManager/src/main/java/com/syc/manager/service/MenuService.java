package com.syc.manager.service;

import java.util.List;

import com.syc.manager.domain.Menu;
import com.syc.manager.vo.Perms;

public interface MenuService {

	List<String> getUserPermissionsList(Integer userId);
	
	List<Perms> findAllUrlPerms();

	List<Menu> getAllMenuForTree();

	List<Integer> findMenuByRoleId(Integer roleId);
}
