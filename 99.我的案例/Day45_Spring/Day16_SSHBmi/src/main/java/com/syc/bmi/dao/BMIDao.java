package com.syc.bmi.dao;

import java.util.List;

import com.syc.bmi.domain.BMI;

public interface BMIDao {

	public List<BMI> queryAll();
	
	public boolean add(BMI bmi);
	
	public boolean delete(BMI bmi);
	
}
