package com.syc.shiro.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syc.shiro.dao.UserDao;
import com.syc.shiro.domain.Permission;
import com.syc.shiro.domain.Role;
import com.syc.shiro.domain.User;
import com.syc.shiro.domain.UserRole;
import com.syc.shiro.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;

	public User findUserByName(String username) {
		String hql = "from User user where user.username=?";
		return (User) dao.findObject(hql, new Object[] { username });
	}

	public List<String> findRolesByName(String username) {
		User user = findUserByName(username);
		if (user == null) {
			return null;
		}

		ArrayList<String> roleNames = new ArrayList<String>();
		List<UserRole> userRoles = user.getUserRoles();
		for (UserRole ur : userRoles) {
			@SuppressWarnings("unchecked")
			List<Role> roles = (List<Role>) dao.findAll("from Role where id=?", new Object[] { ur.getRole().getId() });
			for (Role role : roles) {
				String name = role.getName();
				roleNames.add(name);
			}
		}

		return roleNames;
	}

	public List<String> findPermissionsByName(String username) {
		User user = findUserByName(username);
		if (user == null) {
			return null;
		}

		ArrayList<String> permissionNames = new ArrayList<String>();
		List<UserRole> userRoles = user.getUserRoles();
		for (UserRole ur : userRoles) {
			@SuppressWarnings("unchecked")
			List<Permission> permissions = (List<Permission>) dao.findAll("from Permission where roleId=?", new Object[] { ur.getRole().getId() });
			for(Permission p : permissions){
				String url = p.getUrl();
				permissionNames.add(url);
			}
		}

		return permissionNames;
	}

}
