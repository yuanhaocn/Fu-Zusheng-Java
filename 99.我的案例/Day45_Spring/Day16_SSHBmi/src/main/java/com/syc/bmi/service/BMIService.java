package com.syc.bmi.service;

import java.util.List;

import com.syc.bmi.domain.BMI;

public interface BMIService {

	public List<BMI> queryBMI();
	
	public boolean addBMI(BMI bmi);
	
	public boolean deleteBMI(BMI bmi);
}
