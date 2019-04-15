package com.syc.spring.annotation05.dao.impl;

import org.springframework.stereotype.Repository;

import com.syc.spring.annotation05.dao.UserDao;

@Repository("dao")
public class UserDaoImpl implements UserDao {

	public void findUserByNameAndPass() {
		System.out.println("user表查询....dao层...");
	}

}
