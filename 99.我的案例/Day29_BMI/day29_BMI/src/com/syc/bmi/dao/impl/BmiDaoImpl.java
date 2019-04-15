package com.syc.bmi.dao.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.syc.bmi.dao.IBmiDao;
import com.syc.bmi.domain.BMI;
import com.syc.bmi.utils.C3P0Util;

/**
 * Dao层的具体实现
 * 
 * @类名称:BmiDaoImpl
 * @创建人:SYC
 * @创建时间:2017年8月3日 上午11:45:07
 */
public class BmiDaoImpl implements IBmiDao<BMI> {

	@Override
	public boolean add(BMI bmi) {
		try {
			QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
			String sql = "insert into bmi (recordTime,height,weight,bmi,bmiSign) values(?,?,?,?,?)";
			int result = qr.update(sql, new Date(), bmi.getHeight(), bmi.getWeight(), bmi.getBmi(), bmi.getBmiSign());
			if(result>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@Override
	public List<BMI> query() {
		try {
			QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
			String sql="select * from bmi";
			return qr.query(sql, new BeanListHandler<>(BMI.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	//根据bmiSign来进行删除
	@Override
	public boolean delete(BMI bmi) {
		try {
			QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
			String sql="delete from bmi where bmiSign=?";
			int result = qr.update(sql,bmi.getBmiSign());
			if(result>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
