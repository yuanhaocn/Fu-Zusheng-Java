package com.syc.oa.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syc.oa.domain.TbUser;
import com.syc.oa.domain.TbUserExample;
import com.syc.oa.domain.TbUserExample.Criteria;
import com.syc.oa.mapper.TbUserMapper;
import com.syc.oa.service.UserService;
import com.syc.oa.vo.PageBean;

/*
 * UserService接口实现类.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private TbUserMapper userMapper;

	@Override
	public TbUser findUserByNameAndPassword(String username, String password) {
		TbUserExample example = new TbUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username).andPasswordEqualTo(password);
		List<TbUser> users = userMapper.selectByExample(example);
		if (users != null && users.size() > 0) {
			return users.get(0);
		}
		return null;
	}

	/**
	 * 可以是全部查询,也可以是条件查询
	 */
	@Override
	public PageBean<TbUser> selectAll(String username, String status) {
		TbUserExample example = new TbUserExample();
		Criteria criteria = example.createCriteria();

		if ("".equals(status)) {
			criteria.andUsernameLike("%" + username + "%");
		} else {
			criteria.andStatusEqualTo(Integer.parseInt(status));
			criteria.andUsernameLike("%" + username + "%");
		}

		List<TbUser> users = userMapper.selectByExample(example);

		// 创建一个分页的JavaBean对象
		PageBean<TbUser> bean = new PageBean<>();
		bean.setTotal(users.size());
		bean.setRows(users);

		return bean;
	}

	@Override
	public boolean addUser(TbUser user) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date createdate = format.parse(format.format(new Date()));
			user.setCreatedate(createdate);
			return userMapper.insertSelective(user) > 0;
		} catch (ParseException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public TbUser findUserById(Integer id) {

		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public boolean updateUser(TbUser user) {
		TbUserExample example = new TbUserExample();
		example.createCriteria().andIdEqualTo(user.getId());
		return userMapper.updateByExampleSelective(user, example) > 0;
	}

	@Override
	public boolean removeOne(Integer id) {
		return userMapper.deleteByPrimaryKey(id) > 0;
	}

	@Override
	public boolean removeMore(Integer[] ids) {
		TbUserExample example = new TbUserExample();
		example.createCriteria().andIdIn(Arrays.asList(ids));
		return userMapper.deleteByExample(example)>0;
	}

}
