package com.syc.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syc.ssm.domain.Users;
import com.syc.ssm.domain.UsersExample;
import com.syc.ssm.mapper.UsersMapper;
import com.syc.ssm.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UsersMapper mapper;

	public int registerUser(Users user) {
		return mapper.insertSelective(user);
	}

	public Users login(Users user) {
		UsersExample example = new UsersExample();
		example.createCriteria().andUsernameEqualTo(user.getUsername()).andPasswordEqualTo(user.getPassword());
		List<Users> users = mapper.selectByExample(example);
		if (users != null && users.size() > 0) {
			return users.get(0);
		}
		return null;
	}

}
