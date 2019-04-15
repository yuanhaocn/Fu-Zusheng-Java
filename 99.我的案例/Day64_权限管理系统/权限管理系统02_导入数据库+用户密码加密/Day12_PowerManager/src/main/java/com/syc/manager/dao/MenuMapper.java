package com.syc.manager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.syc.manager.vo.Perms;

public interface MenuMapper {
	
	List<String> getUserPermissionsList(@Param("userId") Integer userId);
	
	List<Perms> findAllUrlPerms();
}
