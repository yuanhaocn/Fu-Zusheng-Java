package com.syc.manager.dao;

import java.util.List;

import com.syc.manager.domain.Menu;
import com.syc.manager.vo.Perms;

public interface MenuMapper {
	
	List<String> getUserPermissionsList(Integer userId);
	
	List<Perms> findAllUrlPerms();

	List<Menu> getAllMenu();
}
