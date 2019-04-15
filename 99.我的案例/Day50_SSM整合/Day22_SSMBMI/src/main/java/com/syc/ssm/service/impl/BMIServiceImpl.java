package com.syc.ssm.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syc.ssm.domain.Bmi;
import com.syc.ssm.domain.BmiExample;
import com.syc.ssm.mapper.BmiMapper;
import com.syc.ssm.service.BMIService;

@Service("bmiService")
public class BMIServiceImpl implements BMIService {

	@Autowired
	private BmiMapper mapper;

	public List<Bmi> queryBMI() {
		//不添加条件,直接传一个Example对象,就是全部查询!
		BmiExample example = new BmiExample();
		return mapper.selectByExample(example);
	}

	public int addBMI(Bmi bmi) {
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		bmi.setRecordtime(format.format(new Date()));
		return mapper.insertSelective(bmi);
	}

	public int deleteBMI(Bmi bmi) {
		BmiExample example = new BmiExample();
		example.createCriteria().andBmisignEqualTo(bmi.getBmisign());
		return mapper.deleteByExample(example);
	}

}
