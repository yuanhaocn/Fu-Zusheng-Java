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

/**
 * 签到管理的实现类
 * 
 * @类名称:SignServiceImpl
 * @创建人:一一哥
 * @创建时间:2018年3月7日 上午9:34:48
 */
@Service
public class SignServiceImpl implements SignService {

	@Autowired
	private TbSignMapper signMapper;

	@Autowired
	private TbUserMapper userMapper;

	@Override
	public PageBean<TbSign> selectSign(String startDate, String endDate) {
		try {
			TbSignExample example = new TbSignExample();
			Criteria criteria = example.createCriteria();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			// 1970-01-01 ~~ 2018-03-03 00:00:00
			Date start = format.parse(startDate + " 00:00:00");
			Date end = format.parse(endDate + " 24:00:00");
			criteria.andCreatetimeBetween(start, end);
			List<TbSign> signs = signMapper.selectByExample(example);

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
	public boolean isSign(Integer uid, String today) {
		try {
			TbSignExample example = new TbSignExample();
			Criteria criteria = example.createCriteria();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = format.parse(today);
			criteria.andUidEqualTo(uid).andCreatetimeGreaterThan(date);
			List<TbSign> signs = signMapper.selectByExample(example);
			if(signs!=null&&signs.size()>0){
				return signs.get(0)!=null;
			}
		} catch (ParseException e) {
			e.printStackTrace();
			return false;
		}

		return false;
	}

	@Override
	public boolean addSign(Integer uid) {
		try {
			TbSign sign=new TbSign();
			sign.setFlag(1);
			sign.setUid(uid);
			sign.setUser(userMapper.selectByPrimaryKey(uid));
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			sign.setCreatetime(format.parse(format.format(new Date())));
			return signMapper.insertSelective(sign)>0;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<SignChart> selectChart(String createTime) {

		return signMapper.selectChart(createTime);
	}

}
