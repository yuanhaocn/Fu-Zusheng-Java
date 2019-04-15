package com.syc.bmi.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.syc.bmi.dao.IBmiDao;
import com.syc.bmi.domain.BMI;

/**
 * Dao层的具体实现
 * 
 * @类名称:BmiDaoImpl
 * @创建人:SYC
 */
public class BmiDaoImpl implements IBmiDao<BMI> {

	// Hibernate的类对象SessionFactory,该对象由Spring容器负责创建
	private SessionFactory factory;

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	//全部查询
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<BMI> query() {
		Session session = factory.openSession();
		Query query = session.createQuery("from BMI");
		List<BMI> list = query.list();
		session.close();
		return list;
	}

	//添加bmi记录
	public boolean add(BMI bmi) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		bmi.setRecordTime(format.format(new Date()));
		Integer result = (Integer) session.save(bmi);
		transaction.commit();
		session.close();
		if (result > 0) {
			return true;
		}
		return false;
	}

	// 根据bmiSign来进行删除
	@SuppressWarnings({ "rawtypes" })
	public boolean delete(BMI bmi) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("delete BMI bmi where bmi.bmiSign=:bmiSign");
		query.setParameter("bmiSign", bmi.getBmiSign());
		// 修改和删除的时候,必须执行该方法.
		int result = query.executeUpdate();
		transaction.commit();
		session.close();
		if(result>0){
			return true;
		}else{
			return false;
		}
	}

}
