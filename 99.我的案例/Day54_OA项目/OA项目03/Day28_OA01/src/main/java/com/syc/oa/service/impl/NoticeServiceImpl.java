package com.syc.oa.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syc.oa.domain.TbAdvice;
import com.syc.oa.domain.TbAdviceExample;
import com.syc.oa.domain.TbUser;
import com.syc.oa.mapper.TbAdviceMapper;
import com.syc.oa.mapper.TbUserMapper;
import com.syc.oa.service.NoticeService;
import com.syc.oa.vo.PageBean;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private TbAdviceMapper adviceMapper;

	@Autowired
	private TbUserMapper userMapper;

	@Override
	public PageBean<TbAdvice> selectNotice(String title) {

		TbAdviceExample example = new TbAdviceExample();
		example.createCriteria().andTitleLike("%" + title + "%");
		// 查询包含大文本的数据
		List<TbAdvice> notices = adviceMapper.selectByExampleWithBLOBs(example);
		for (TbAdvice advice : notices) {// 关联查询用户信息
			TbUser user = userMapper.selectByPrimaryKey(advice.getUid());
			advice.setUser(user);
		}

		PageBean<TbAdvice> bean = new PageBean<>();
		bean.setRows(notices);
		bean.setTotal(notices.size());

		return bean;
	}

	@Override
	public boolean addNotice(TbAdvice advice) {
		try {
			TbUser user = userMapper.selectByPrimaryKey(advice.getUid());
			advice.setUser(user);

			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date createdate = format.parse(format.format(new Date()));
			advice.setCreatedate(createdate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return adviceMapper.insertSelective(advice) > 0;
	}

	@Override
	public TbAdvice selectById(Integer id) {
		return adviceMapper.selectByPrimaryKey(id);
	}

	@Override
	public boolean updateNotice(TbAdvice advice) {

		return adviceMapper.updateByPrimaryKeySelective(advice) > 0;
	}

	@Override
	public void removeOne(Integer id) {
		adviceMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void removeMore(Integer[] ids) {
		TbAdviceExample example = new TbAdviceExample();
		example.createCriteria().andIdIn(Arrays.asList(ids));
		adviceMapper.deleteByExample(example);
	}

}
