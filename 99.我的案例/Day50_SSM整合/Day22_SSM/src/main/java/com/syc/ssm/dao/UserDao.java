package com.syc.ssm.dao;

import java.sql.SQLException;

import com.syc.ssm.domain.User;

public interface UserDao {

	public User selectByNameAndPass(User user) throws SQLException;

	public int insertUser(User user) throws SQLException;
}
