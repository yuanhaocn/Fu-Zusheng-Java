package com.syc.layer.service;

import com.syc.layer.domain.User;

/**
 * 业务逻辑层的接口.
 * @类名称:ILoginService
 * @创建人:SYC
 * @创建时间:2017年7月31日 上午11:47:11
 * 注意:在业务层定义类名还是方法名的时候,都应该突出该业务的名称.
 */
public interface ILoginService {
	
	//登陆方法
	public User login(User user);
	
	//注册方法
	public void register(User user);
}
