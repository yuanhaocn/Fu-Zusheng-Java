package com.syc.sh.dao;

import java.util.List;

import com.syc.sh.domain.CityWeather;

public interface CityWeatherDao {

	public List<CityWeather> queryWeather(CityWeather city);
}
