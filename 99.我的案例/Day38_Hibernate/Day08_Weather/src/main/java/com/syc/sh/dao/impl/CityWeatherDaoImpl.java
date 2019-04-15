package com.syc.sh.dao.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.syc.sh.dao.CityWeatherDao;
import com.syc.sh.domain.CityWeather;
import com.syc.sh.utils.HibernateUtil;

/**
 * 天气查询的dao层实现类
 * @类名称:CityWeatherDaoImpl
 * @创建人:一一哥
 * @创建时间:2017年11月22日 下午3:04:03
 */
@SuppressWarnings("unused")
public class CityWeatherDaoImpl implements CityWeatherDao {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<CityWeather> queryWeather(CityWeather city) {

		Session session = HibernateUtil.openSession();
		
		//CityWeather cityWeather = session.get(CityWeather.class, 1);
		//CityWeather cityWeather = session.load(CityWeather.class, 1);
		
		//hql语法.
		Query query = session.createQuery("from CityWeather c where c.city=?");
		//query.setString(0, cityName);
		query.setParameter(0, city.getCity());
		
		List<CityWeather> list = query.list();
		
		session.close();
		
		return list;
	}

}
