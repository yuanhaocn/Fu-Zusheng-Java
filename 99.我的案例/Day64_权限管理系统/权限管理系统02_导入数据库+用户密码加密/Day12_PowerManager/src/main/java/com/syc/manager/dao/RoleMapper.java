package com.syc.manager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface RoleMapper {

	List<String> getUserRoleList(@Param("userId") Integer userId);
}
