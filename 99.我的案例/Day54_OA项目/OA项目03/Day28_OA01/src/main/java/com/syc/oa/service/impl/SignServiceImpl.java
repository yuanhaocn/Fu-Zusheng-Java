package com.syc.oa.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syc.oa.domain.TbSign;
import com.syc.oa.domain.TbSignExample;
import com.syc.oa.domain.TbSignExample.Criteria;
import com.syc.oa.mapper.TbSignMapper;
import com.syc.oa.mapper.TbUserMapper;
import com.syc.oa.service.SignService;
import com.syc.oa.vo.PageBean;
import com.syc.oa.vo.SignChart;

@Service
public class SignServiceImpl implements SignService {

	@Autowired
	private TbSignMapper signMapper;

	@Autowired
	private TbUserMapper userMapper;

	@Override
	public boolean isSign(Integer uid, String today) {
		try {
			TbSignExample example = new TbSignExample();
			Criteria criteria = example.createCriteria();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date parseDate = format.parse(today);
			criteria.andUidEqualTo(uid).andCreatetimeGreaterThan(parseDate);
			List<TbSign> signs = signMapper.selectByExample(example);
			if (signs != null && signs.size() > 0) {
				return signs.get(0) != null;
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public PageBean<TbSign> selectSign(String startDate, String endDate) {
		try {
			TbSignExample example = new TbSignExample();
			Criteria criteria = example.createCriteria();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

			// 2017-12-01 ~ 2017-12-28
			Date start = format.parse(startDate + " 00:00:00");
			Date end = format.parse(endDate + " 24:00:00");
			System.out.println("start=" + format.format(start));
			System.out.println("end=" + format.format(end));
			criteria.andCreatetimeBetween(start, end);
			List<TbSign> signs = signMapper.selectByExample(example);

			// 关联查询user表
			for (TbSign sign : signs) {
				sign.setUser(userMapper.selectByPrimaryKey(sign.getUid()));
			}

			PageBean<TbSign> bean = new PageBean<>();
			bean.setRows(signs);
			bean.setTotal(signs.size());

			return bean;
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean addSign(Integer uid) {
		TbSign sign = new TbSign();
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			sign.setCreatetime(format.parse(format.format(new Date())));
			// 表示已打卡
			sign.setFlag(1);
			sign.setUid(uid);
			sign.setUser(userMapper.selectByPrimaryKey(uid));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return signMapper.insertSelective(sign) > 0;
	}

	@Override
	public List<SignChart> selectChartData(String beginDay) {
		return signMapper.findSignChart(beginDay);
	}

}
