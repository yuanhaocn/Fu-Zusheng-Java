package com.syc.layer.dao;

import java.sql.SQLException;

import com.syc.layer.domain.User;

/**
 * 数据访问层,进行数据库的CRUD.
 * @类名称:IUserDao
 * @创建人:SYC
 * @创建时间:2017年7月31日 上午11:50:53
 * 如果该类名叫ILoginDao合适吗?
 * 
 */
public interface IUserDao {

	//重点体现的是对某个表的操作,而不是对某个业务的实现.
	public void addUser(User user) throws SQLException;
	
	//查询User表
	public User findUser(User user) throws SQLException;
}
