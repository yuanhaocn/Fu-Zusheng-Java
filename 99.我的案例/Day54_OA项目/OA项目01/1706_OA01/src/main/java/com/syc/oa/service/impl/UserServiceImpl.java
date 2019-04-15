package com.syc.oa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syc.oa.domain.TbUser;
import com.syc.oa.domain.TbUserExample;
import com.syc.oa.domain.TbUserExample.Criteria;
import com.syc.oa.mapper.TbUserMapper;
import com.syc.oa.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private TbUserMapper userMapper;

	@Override
	public TbUser findUserByNameAndPassword(String name, String password) {

		TbUserExample example = new TbUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(name).andPasswordEqualTo(password);
		List<TbUser> users = userMapper.selectByExample(example);
		if (users != null && users.size() > 0) {
			return users.get(0);
		}

		return null;
	}

}
