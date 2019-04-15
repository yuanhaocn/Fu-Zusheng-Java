package com.syc.bmi.service.impl;

import java.util.List;

import com.syc.bmi.dao.IBmiDao;
import com.syc.bmi.dao.impl.BmiDaoImpl;
import com.syc.bmi.domain.BMI;
import com.syc.bmi.service.IBmiService;

/**
 * 业务逻辑层的实现,通过调用Dao层来具体实现.
 * @类名称:BmiServiceImpl
 * @创建人:SYC
 * @创建时间:2017年8月3日 上午11:42:54
 */
public class BmiServiceImpl implements IBmiService<BMI>{

	private IBmiDao<BMI> dao=new BmiDaoImpl();
	
	@Override
	public boolean addBMI(BMI t) {
		return dao.add(t);
	}

	@Override
	public List<BMI> queryBMI() {
		return dao.query();
	}

	@Override
	public boolean deleteBMI(BMI t) {
		return dao.delete(t);
	}

}
