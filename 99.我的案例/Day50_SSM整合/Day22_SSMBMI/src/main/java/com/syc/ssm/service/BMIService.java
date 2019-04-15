package com.syc.ssm.service;

import java.util.List;

import com.syc.ssm.domain.Bmi;

public interface BMIService {

	public List<Bmi> queryBMI();

	public int addBMI(Bmi bmi);

	public int deleteBMI(Bmi bmi);
}
