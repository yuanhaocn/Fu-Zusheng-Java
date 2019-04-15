package com.syc.manager.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.syc.manager.dao.UserMapper;
import com.syc.manager.dao.UserRoleMapper;
import com.syc.manager.domain.User;
import com.syc.manager.service.UserService;
import com.syc.manager.util.MyLog;
import com.syc.manager.vo.PageBean;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private UserRoleMapper userRoleMapper;

	@Override
	public User findUserByUserName(String username) {
		MyLog.log("userservice---->" + username);
		return userMapper.findUserByUserName(username);
	}

	@Override
	public PageBean<User> findAllUsers(Integer currentPage, Integer pageSize) {
		// 1.先开始分页
		PageHelper.startPage(currentPage, pageSize);

		// 2.再进行查询
		List<User> users = userMapper.findAllUsers();

		PageInfo<User> info = new PageInfo<>(users);
		long total = info.getTotal();

		return new PageBean<>(total, users);
	}

	@Override
	public void addUser(User user) {
		if (userMapper.addUser(user) > 0) {
			// 级联添加到user_role表中
			List<Integer> roleIdList = user.getRoleIdList();
			if (roleIdList != null && roleIdList.size() != 0) {
				userRoleMapper.saveUserRole(user.getUserId(), roleIdList);
			}
		}
	}

	@Override
	public User findUserById(Integer userId) {

		return userMapper.findUserById(userId);
	}

	@Override
	public void updateUser(User user) throws SQLException {

		// 1.修改用户自身的信息;
		int result = userMapper.updateUser(user);
		if (result > 0) {

			// 2.删除原有的角色信息;
			userRoleMapper.deleteByUserId(user.getUserId());

			// 3.添加新型的角色信息.
			List<Integer> roleIdList = user.getRoleIdList();
			if (roleIdList != null && roleIdList.size() != 0) {
				userRoleMapper.saveUserRole(user.getUserId(), roleIdList);
			}
		}

	}

	@Override
	public void deleteUser(Integer[] ids) throws SQLException {
		userMapper.deleteUser(ids);
		
		//级联删除用户对应的角色信息
		for(int i=0;i<ids.length;i++){
			userRoleMapper.deleteByUserId(ids[i]);
		}
	}

	@Override
	public List<String> getManagerNameList() {

		return userMapper.getManagerNameList();
	}

}
