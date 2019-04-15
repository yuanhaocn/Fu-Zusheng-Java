package com.syc.oa.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.syc.oa.domain.TbSign;
import com.syc.oa.domain.TbSignExample;
import com.syc.oa.domain.TbSignExample.Criteria;
import com.syc.oa.domain.TbUser;
import com.syc.oa.mapper.TbSignMapper;
import com.syc.oa.mapper.TbUserMapper;
import com.syc.oa.service.SignService;
import com.syc.oa.vo.PageBean;
import com.syc.oa.vo.SignChart;

/**
 * 签到业务处理的接口实现类
 */
@Service("signService")
@Transactional(isolation = Isolation.DEFAULT, readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class SignServiceImpl implements SignService {

	@Autowired
	private TbSignMapper signMapper;

	@Autowired
	private TbUserMapper userMapper;

	/**
	 * 判断用户今天是否已签到!
	 */
	@Override
	public boolean isSign(Integer uid, String today) {
		TbSignExample example = new TbSignExample();
		// SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd
		// hh:mm:ss");
		// example.createCriteria().andUidEqualTo(uid).andFlagEqualTo(1).andCreatetimeGreaterThan(format.parse(today));
		// 判断是否已签到的条件为:
		// 1.uid一致;
		// 2.flag=1;
		// 3.签到时间?
		example.createCriteria().andUidEqualTo(uid).andFlagEqualTo(1);
		List<TbSign> signs = signMapper.selectByExample(example);
		if (signs != null && signs.size() > 0) {
			TbSign sign = signs.get(0);
			return sign != null;
		}
		return false;
	}

	/**
	 * 添加签到打卡信息
	 */
	@Override
	public boolean addSign(Integer uid) {
		TbSign sign = new TbSign();
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date date = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
			sign.setCreateTime(date);
			sign.setUid(uid);
			// 设置打卡状态
			sign.setFlag(1);
			// 设置关联的用户
			TbUser user = userMapper.selectByPrimaryKey(uid);
			sign.setUser(user);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return signMapper.insertSelective(sign) > 0;
	}

	/**
	 * 查询签到打卡信息
	 */
	@Override
	public PageBean<TbSign> findSign(Map<String, Object> map) {

		// 分页设置
		PageBean<TbSign> bean = null;

		try {
			String start = (String) map.get("startDate");
			String end = (String) map.get("endDate");
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			//修复bug!!!
			//限定查询签到时间范围是"start 00:00:00"到"end 24:00:00",否则签到查询的结果会有遗漏! 
			Date startDate = format.parse(start+" 00:00:00");
			Date endDate = format.parse(end+" 24:00:00");
			TbSignExample example = new TbSignExample();
			Criteria criteria = example.createCriteria();
			criteria.andCreatetimeBetween(startDate, endDate);
			List<TbSign> signs = signMapper.selectByExample(example);
			// 关联查询
			for (TbSign sign : signs) {
				Integer uid = sign.getUid();
				TbUser user = userMapper.selectByPrimaryKey(uid);
				sign.setUser(user);
				sign.getUser().setDocuments(null);
				sign.getUser().setSigns(null);
			}

			// 分页设置
			bean = new PageBean<>();
			bean.setRows(signs);
			bean.setTotal(signs.size());
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}

		return bean;
	}

	/**
	 * 查询签到打卡图表信息
	 */
	@Override
	public List<SignChart> findSignChart(String beginDay) {
		return signMapper.findSignChart(beginDay);
	}
}
