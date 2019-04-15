package com.syc.oa.service;

import com.syc.oa.domain.TbUser;
import com.syc.oa.vo.PageBean;

/*
 * 用户模块的接口
 */
public interface UserService {

	// 根据用户名和密码进行查询
	public TbUser findUserByNameAndPassword(String username, String password);

	// 全部查询
	public PageBean<TbUser> selectAll(String username, String status);
	
	//添加用户
	public boolean addUser(TbUser user);
	
	//根据id查找对象
	public TbUser findUserById(Integer id);
	
	//修改用户信息
	public boolean updateUser(TbUser user);
	
	//单个删除方法
	public boolean removeOne(Integer id);
	
	//批量删除
	public boolean removeMore(Integer[] ids);
}
