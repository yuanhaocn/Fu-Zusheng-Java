package com.syc.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syc.manager.dao.RoleMapper;
import com.syc.manager.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleMapper roleMapper;
	
	@Override
	public List<String> getUserRoleList(Integer userId) {
		return roleMapper.getUserRoleList(userId);
	}

}
