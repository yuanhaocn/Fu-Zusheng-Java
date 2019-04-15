package com.syc.oa.service;

import com.syc.oa.domain.TbUser;
import com.syc.oa.vo.PageBean;

/**
 * 用户模块的接口
 * 
 * @类名称:UserService
 * @创建人:SYC
 * @创建时间:2017年10月31日 下午4:09:37
 */
public interface UserService {

	// 根据用户名和密码进行查询
	public TbUser findUserNameByNameAndPassword(String userName, String password);

	// 添加用户
	public boolean addUser(TbUser user);

	//查询全部
	public PageBean<TbUser> selectAll(Integer pageNum, Integer pageSize, String username, String status);

	//根据id查找对应的对象
	public TbUser findUserById(Integer id);

	//修改对象的方法
	public boolean updateUser(TbUser user);

	//删除单个用户
	public boolean removeOne(Integer id);

	//批量删除用户
	public boolean remove(Integer[] ids);
}
