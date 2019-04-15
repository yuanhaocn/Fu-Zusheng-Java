package com.syc.manager.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.syc.manager.domain.User;

public interface UserMapper {

	User findUserByUserName(String username);

	List<User> findAllUsers();

	int addUser(User user);

	User findUserById(Integer userId);

	int updateUser(@Param("user") User user) throws SQLException;

	void deleteUser(@Param("userIds") Integer[] userIds) throws SQLException;

	List<String> getManagerNameList();
}
