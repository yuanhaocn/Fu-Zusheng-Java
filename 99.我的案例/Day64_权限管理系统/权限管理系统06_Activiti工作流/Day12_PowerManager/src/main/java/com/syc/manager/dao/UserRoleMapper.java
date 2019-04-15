package com.syc.manager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * 对应着user_role表
 * @类名称:UserRoleMapper
 * @创建人:一一哥
 * @创建时间:2018年3月15日 上午11:40:58
 */
public interface UserRoleMapper {
	
	void saveUserRole(@Param("userId") Integer userId,@Param("roleIdList") List<Integer> roleIdList);

	void deleteByUserId(Integer userId);
	
}
