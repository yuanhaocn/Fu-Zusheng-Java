package com.syc.bmi.service.impl;

import java.util.List;

import com.syc.bmi.dao.IBmiDao;
import com.syc.bmi.domain.BMI;
import com.syc.bmi.service.IBmiService;

/**
 * 业务逻辑层的实现,通过调用Dao层来具体实现.
 * 
 * @类名称:BmiServiceImpl
 * @创建人:SYC
 */
public class BmiServiceImpl implements IBmiService<BMI> {

	private IBmiDao<BMI> dao;

	public void setDao(IBmiDao<BMI> dao) {
		this.dao = dao;
	}

	public List<BMI> queryBMI() {
		return dao.query();
	}

	public boolean addBMI(BMI t) {
		return dao.add(t);
	}

	public boolean deleteBMI(BMI t) {
		return dao.delete(t);
	}

}
