package com.syc.oa.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.syc.oa.domain.TbAdvice;
import com.syc.oa.domain.TbAdviceExample;
import com.syc.oa.domain.TbAdviceExample.Criteria;
import com.syc.oa.domain.TbUser;
import com.syc.oa.mapper.TbAdviceMapper;
import com.syc.oa.mapper.TbUserMapper;
import com.syc.oa.service.NoticeService;
import com.syc.oa.vo.PageBean;

/**
 * 公告模块的具体实现类
 * 
 * @类名称:NoticeServiceImpl
 * @创建人:SYC
 * @创建时间:2017年11月2日 下午2:40:34
 */
@Service("noticeService")
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private TbAdviceMapper adviceMapper;

	@Autowired
	private TbUserMapper userMapper;

	/**
	 * 实现添加公告
	 */
	@Override
	public boolean addNotice(Integer uid, TbAdvice advice) {
		try {
			// 关联查询tb_user表
			TbUser user = userMapper.selectByPrimaryKey(uid);
			advice.setUser(user);

			// 设置添加时间
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date createDate = format.parse(format.format(new Date()));
			advice.setCreateDate(createDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return adviceMapper.insertSelective(advice) > 0;
	}

	/**
	 * 查询公告
	 */
	@Override
	public PageBean<TbAdvice> selectAdvice(Map<String, Object> map) {

		String title = (String) map.get("title");
		// String content = (String) map.get("content");

		TbAdviceExample example = new TbAdviceExample();
		Criteria criteria = example.createCriteria();
		criteria.andTitleLike("%" + title + "%");

		// adviceMapper.selectByExample(example);
		List<TbAdvice> advices = adviceMapper.selectByExampleWithBLOBs(example);

		// 此处:必须关联查询tb_user表,将user对象封装到TbAdvice中!
		for (TbAdvice adv : advices) {
			TbUser user = userMapper.selectByPrimaryKey(adv.getUid());
			adv.setUser(user);
		}

		// 分页
		PageBean<TbAdvice> bean = new PageBean<>();
		bean.setRows(advices);
		bean.setTotal(advices.size());

		return bean;
	}

	/**
	 * 查询TbAdvice
	 */
	@Override
	public TbAdvice selectAdviceById(Integer id) {

		TbAdvice advice = adviceMapper.selectByPrimaryKey(id);

		// 关联User对象
		Integer uid = advice.getUid();
		TbUser user = userMapper.selectByPrimaryKey(uid);
		advice.setUser(user);

		return advice;
	}

	/**
	 * 修改公告的实现
	 */
	@Override
	public boolean editNotice(TbAdvice advice) {
		return adviceMapper.updateByPrimaryKeySelective(advice) > 0;
	}

	/**
	 * 单个删除
	 */
	@Override
	public boolean removeById(Integer id) {
		return adviceMapper.deleteByPrimaryKey(id) > 0;
	}

	/**
	 * 批量上传
	 */
	@Override
	public boolean removeMore(Integer[] ids) {
		TbAdviceExample example = new TbAdviceExample();
		Criteria criteria = example.createCriteria();

		for (int i = 0; i < ids.length; i++) {
			criteria.andIdIn(Arrays.asList(ids));
		}

		return adviceMapper.deleteByExample(example) > 0;
	}

}
