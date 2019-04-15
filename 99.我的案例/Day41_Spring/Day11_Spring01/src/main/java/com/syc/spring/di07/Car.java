package com.syc.spring.di07;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Car {

	// 基本数据类型+String类型
	private int id;
	private float price;
	private String color;

	// 引用类型
	private BMWCar bmw;

	// 集合类型
	private List<?> carList;
	private Set<String> carSet;
	private Map<String, String> carMap;
	private Object[] objs;

	// 配置类型
	private Properties props;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public BMWCar getBmw() {
		return bmw;
	}

	public void setBmw(BMWCar bmw) {
		this.bmw = bmw;
	}

	public List<?> getCarList() {
		return carList;
	}

	public void setCarList(List<?> carList) {
		this.carList = carList;
	}

	public Set<String> getCarSet() {
		return carSet;
	}

	public void setCarSet(Set<String> carSet) {
		this.carSet = carSet;
	}

	public Map<String, String> getCarMap() {
		return carMap;
	}

	public void setCarMap(Map<String, String> carMap) {
		this.carMap = carMap;
	}

	public Object[] getObjs() {
		return objs;
	}

	public void setObjs(Object[] objs) {
		this.objs = objs;
	}

	public Properties getProps() {
		return props;
	}

	public void setProps(Properties props) {
		this.props = props;
	}

}
