package com.syc.oa.service;

import com.syc.oa.domain.TbUser;
import com.syc.oa.vo.PageBean;

/**
 * 用户管理的接口
 * @类名称:UserService
 * @创建人:一一哥
 * @创建时间:2018年2月27日 下午2:34:27
 */
public interface UserService {

	TbUser findUserByNameAndPassword(String name,String password);
	
	PageBean<TbUser> selectAll(String username,String status);
	
	boolean addUser(TbUser user);
	
	boolean updateUser(TbUser user);

	TbUser findUserById(Integer id);

	boolean removeOne(Integer id);

	boolean removeMore(Integer[] ids);
}
