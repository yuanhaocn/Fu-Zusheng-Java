package com.syc.ws.wstest;

import javax.xml.namespace.QName;
import javax.xml.ws.*;

import com.syc.ws.weather03.ArrayOfString;
import com.syc.ws.weather03.WeatherWSSoap;

import java.net.MalformedURLException;
import java.net.URL;

public class WeatherTest03 {

	@SuppressWarnings("restriction")
	public static void main(String[] args) {
		try {
			URL url = new URL("http://ws.webxml.com.cn/WebServices/WeatherWS.asmx?wsdl");

			QName qName = new QName("http://WebXml.com.cn/", "WeatherWS");
			
			Service service = Service.create(url, qName);
			WeatherWSSoap port = service.getPort(WeatherWSSoap.class);
			
			//获取天气信息
			ArrayOfString weather = port.getWeather("宝山", null);
			for(String msg : weather.getString()){
				System.out.println("天气信息="+msg);
			}
			
			//支持的国家
			ArrayOfString regionCountry = port.getRegionCountry();
			for(String country : regionCountry.getString()){
				System.out.println("country="+country);
			}
			
			//支持的省份
			ArrayOfString regionProvince = port.getRegionProvince();
			for(String province : regionProvince.getString()){
				System.out.println("province="+province);
			}
			
			//某个省下的市
			ArrayOfString citys = port.getSupportCityString("31111");
			for(String city : citys.getString()){
				System.out.println("city="+city);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
