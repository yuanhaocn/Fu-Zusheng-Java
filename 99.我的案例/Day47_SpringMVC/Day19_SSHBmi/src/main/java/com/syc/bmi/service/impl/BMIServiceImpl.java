package com.syc.bmi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.syc.bmi.dao.BMIDao;
import com.syc.bmi.domain.BMI;
import com.syc.bmi.service.BMIService;

@Service("bmiService")
public class BMIServiceImpl implements BMIService {

	@Autowired
	@Qualifier("bmiDao")
	private BMIDao dao;

	public void setDao(BMIDao dao) {
		this.dao = dao;
	}

	public List<BMI> queryBMI() {
		return dao.queryAll();
	}

	public boolean addBMI(BMI bmi) {
		return dao.add(bmi);
	}

	public boolean deleteBMI(BMI bmi) {
		return dao.delete(bmi);
	}

}
