package com.syc.bmi.service.impl;

import java.util.List;

import com.syc.bmi.dao.BMIDao;
import com.syc.bmi.domain.BMI;
import com.syc.bmi.service.BMIService;

public class BMIServiceImpl implements BMIService {

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
