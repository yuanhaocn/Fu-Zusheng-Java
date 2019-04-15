package com.syc.utils.base03;

import java.util.List;

import com.syc.utils.bean.User;

/**
 * 处理具体业务的Dao类.
 * 
 * @类名称:UserDao
 * @创建人:SYC
 * @创建时间:2017年7月13日 下午3:39:37
 */
public class UserDao extends BaseDao {

	/**
	 * User表的添加
	 * 
	 * @方法名称:insertUser
	 * @创建时间:2017年7月13日 下午3:55:01
	 * @返回类型:int
	 */
	public int insertUser(User user) {
		String sql = "insert into user (username,password) values(?,?)";
		Object[] params = { user.getUsername(), user.getPassword() };
		return super.update(sql, params);
	}

	// 修改方法
	public int updateUser(User user) {
		String sql = "update user set username=?,password=? where id=?";
		Object[] params = { user.getUsername(), user.getPassword(), user.getId() };
		return super.update(sql, params);
	}

	// 删除方法
	public int deleteUser(User user) {
		String sql = "delete from user where id=?";
		Object[] params = { user.getId() };
		return super.update(sql, params);
	}

	//根据id得到对应的记录
	public User findUserByID(int id) {
		String sql = "select * from user where id=?";
		Object[] params = { id };
		List<User> users = super.query(sql, params, User.class);
		return (users != null && users.size() > 0) ? users.get(0) : null;
	}
	
	public User findUserByID(User user) {
		String sql = "select * from user where id=?";
		Object[] params = { user.getId() };
		List<User> users = super.query(sql, params, User.class);
		return (users != null && users.size() > 0) ? users.get(0) : null;
	}
	
	//全部查询
	public List<User> findAllUsers() {
		String sql = "select * from user";
		return super.query(sql, null, User.class);
	}
}
