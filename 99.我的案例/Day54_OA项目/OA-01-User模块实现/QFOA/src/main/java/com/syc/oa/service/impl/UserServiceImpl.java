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

/**
 * 用户模块的Service实现类
 * @类名称:UserServiceImpl
 * @创建人:SYC
 * @创建时间:2017年11月1日 上午11:58:54
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private TbUserMapper userMapper;

	/**
	 * 根据用户名密码实现登陆
	 */
	public TbUser findUserNameByNameAndPassword(String userName, String password) {
		TbUserExample example = new TbUserExample();
		example.createCriteria().andUsernameEqualTo(userName).andPasswordEqualTo(password);
		List<TbUser> users = userMapper.selectByExample(example);
		if (users != null && users.size() > 0) {
			return users.get(0);
		}
		return null;
	}

	/**
	 * 添加用户
	 */
	public boolean addUser(TbUser user) {
		try {
			// 添加时间
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date createDate = format.parse(format.format(new Date()));
			user.setCreateDate(createDate);
			return userMapper.insertSelective(user) > 0;
		} catch (ParseException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 根据用户名和状态进行查询
	 * pageNum和pageSize参数没有用到!
	 */
	public PageBean<TbUser> selectAll(Integer pageNum, Integer pageSize, String username, String status) {

		TbUserExample example = new TbUserExample();
		Criteria criteria = example.createCriteria();

		if ("".equals(status)) {
			//注意:模糊查询时,如果值为空,比如username="",效果等同于没有设置该查询条件!
			criteria.andUsernameLike("%" + username + "%");
		} else {
			//因为status默认值为0,所以页面已加载就会进入到这里,查询status=0的条目.
			criteria.andStatusEqualTo(Integer.parseInt(status));
			criteria.andUsernameLike("%" + username + "%");
		}

		//用户名和密码为空时就默认全部查询了!
		List<TbUser> users = userMapper.selectByExample(example);

		// 设置分页用的JavaBean
		PageBean<TbUser> bean = new PageBean<TbUser>();
		bean.setRows(users);
		bean.setTotal(users.size());

		return bean;
	}

	/**
	 * 根据id查询单个用户
	 */
	public TbUser findUserById(Integer id) {
		return userMapper.selectByPrimaryKey(id);
	}

	/**
	 * 根据id修改单个用户
	 */
	public boolean updateUser(TbUser user) {
		TbUserExample example = new TbUserExample();
		example.createCriteria().andIdEqualTo(user.getId());
		return userMapper.updateByExampleSelective(user, example) > 0;
	}
	
	/**
	 * 删除单个对象
	 */
	public boolean removeOne(Integer id) {
		return userMapper.deleteByPrimaryKey(id)>0;
	}

	/**
	 * 批量删除
	 */
	public boolean removeMore(Integer[] ids) {
		TbUserExample example=new TbUserExample();
		Criteria criteria = example.createCriteria();
		
		//for(int i=0;i<ids.length;i++){
			criteria.andIdIn(Arrays.asList(ids));
		//}
		
		return userMapper.deleteByExample(example)>0;
	}

}
