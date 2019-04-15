package com.syc.bmi.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.syc.bmi.dao.BMIDao;
import com.syc.bmi.domain.BMI;

@Repository("bmiDao")
public class BMIDaoImpl implements BMIDao {

	@Autowired
	@Qualifier("factory")
	private SessionFactory factory;

	// 全部查询
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<BMI> queryAll() {
		Session session = factory.openSession();

		Query query = session.createQuery("from BMI");

		List<BMI> list = query.list();

		session.close();

		return list;
	}

	// 添加BMI
	public boolean add(BMI bmi) {

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		// 设置时间
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		bmi.setRecordTime(format.format(new Date()));
		Integer result = (Integer) session.save(bmi);

		transaction.commit();
		session.close();

		if (result > 0) {
			return true;
		}

		return false;
	}

	// 删除方法
	@SuppressWarnings("rawtypes")
	public boolean delete(BMI bmi) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		// 删除语句
		Query query = session.createQuery("delete from BMI bmi where bmi.bmiSign=:bmiSign");
		query.setParameter("bmiSign", bmi.getBmiSign());
		int result = query.executeUpdate();

		transaction.commit();
		session.close();

		if (result > 0) {
			return true;
		}

		return false;
	}

}
