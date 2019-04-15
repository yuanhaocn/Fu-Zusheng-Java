package com.syc.sh.service.impl;

import java.util.List;

import com.syc.sh.dao.CityWeatherDao;
import com.syc.sh.dao.impl.CityWeatherDaoImpl;
import com.syc.sh.domain.CityWeather;
import com.syc.sh.service.CityWeatherService;

/**
 * service层的实现类
 * @类名称:CityWeatherServiceImpl
 * @创建人:一一哥
 * @创建时间:2017年11月22日 下午3:37:10
 */
public class CityWeatherServiceImpl implements CityWeatherService{

	private CityWeatherDao dao=new CityWeatherDaoImpl();
	
	public List<CityWeather> queryWeather(CityWeather city) {

		return dao.queryWeather(city);
	}

}
