package com.syc.sh.service;

import java.util.List;

import com.syc.sh.domain.CityWeather;

public interface CityWeatherService {

	public List<CityWeather> queryWeather(CityWeather city);
}
