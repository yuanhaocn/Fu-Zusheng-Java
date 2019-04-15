package com.syc.manager.service;

import java.sql.SQLException;

import com.syc.manager.domain.User;
import com.syc.manager.vo.PageBean;

public interface UserService {

	User findUserByUserName(String username);
	
	PageBean<User> findAllUsers(Integer currentPage,Integer pageSize);

	void addUser(User user);

	User findUserById(Integer userId);

	void updateUser(User user) throws SQLException;

	void deleteUser(Integer[] ids) throws SQLException;
}
