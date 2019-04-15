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
		List<TbAdvice> advices = adviceMapper.selectByExampleWithBLOBs(example);

		for (TbAdvice advice : advices) {
			TbUser user = userMapper.selectByPrimaryKey(advice.getUid());
			advice.setUser(user);
		}

		PageBean<TbAdvice> bean = new PageBean<>();
		bean.setTotal(advices.size());
		bean.setRows(advices);

		return bean;
	}

	@Override
	public boolean addNotice(TbAdvice advice) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			advice.setCreatedate(format.parse(format.format(new Date())));
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
	public boolean removeOne(Integer id) {
		return adviceMapper.deleteByPrimaryKey(id)>0;
	}

	@Override
	public boolean removeMore(Integer[] ids) {
		TbAdviceExample example=new TbAdviceExample();
		example.createCriteria().andIdIn(Arrays.asList(ids));
		return adviceMapper.deleteByExample(example)>0;
	}

}
