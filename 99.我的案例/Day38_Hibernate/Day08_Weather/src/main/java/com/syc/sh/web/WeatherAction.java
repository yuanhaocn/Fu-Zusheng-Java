package com.syc.sh.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.syc.sh.domain.CityWeather;
import com.syc.sh.service.CityWeatherService;
import com.syc.sh.service.impl.CityWeatherServiceImpl;

/*
 * web层的Action类
 */
public class WeatherAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private CityWeather weather = new CityWeather();

	public CityWeather getWeather() {
		return weather;
	}

	public void setWeather(CityWeather weather) {
		this.weather = weather;
	}

	private CityWeatherService service = new CityWeatherServiceImpl();

	/*
	 * 处理请求的方法
	 */
	public void searchWeather() {
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
				
			List<CityWeather> list = service.queryWeather(weather);
			//把该集合转换为json字符串.
			// alibaba的fastjson中有2大类方法:parseXXX();toXXX()
			//{},[{},{}]
			String json = JSON.toJSONString(list);
			PrintWriter writer = response.getWriter();
			writer.print(json);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
